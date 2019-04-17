package com.itechart.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ShufflingApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Shuffling Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  // CFF is a Swiss train company
  case class CFFPurchase(customerId: Long, destination: String, price: BigDecimal)

  // Assume that we have an RDD of purchases users of CFFs mobile app have made in the past month
  private val purchases = List(
    CFFPurchase(100, "Geneva", 22.25),
    CFFPurchase(300, "Zurich", 42.10),
    CFFPurchase(100, "Fribourg", 12.40),
    CFFPurchase(200, "St.Gallen", 8.20),
    CFFPurchase(100, "Lucerne", 31.60),
    CFFPurchase(300, "Basel", 16.20))

  def mainTestable(spark: SparkContext): Unit = {

    val purchasesRdd: RDD[CFFPurchase] = spark.parallelize(purchases)

    val purchasesPerMonth = purchasesRdd.map(p => (p.customerId, p.price)) // pair RDD
      .groupByKey() // RDD[K, Iterable[V]] i.e RDD[p.customerId, Iterable[p.price]]
      .map(p => (p._1, (p._2.size, p._2.sum)))
      .collect()

    purchasesPerMonth.foreach(println)
  }

  def mainTestableImproved(spark: SparkContext): Unit = {

    val purchasesRdd: RDD[CFFPurchase] = spark.parallelize(purchases)

    val purchasesPerMonth = purchasesRdd.map(p => (p.customerId, (1L, p.price))) // pair RDD
      .reduceByKey((v1, v2) => (v1._1 + v2._1, v1._2 + v2._2))
      .collect()

    purchasesPerMonth.foreach(println)
  }

}