package com.itechart.spark.internals

import org.apache.spark.{SparkConf, SparkContext}

object RepartitionApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Repartition Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {

    val data = spark.textFile("src/main/resources/data/lines.txt.gz")
    println("Number of partitions:")
    println(data.getNumPartitions)

    // Internally, this uses a shuffle to redistribute data.
    val data2 = data.repartition(32)
    println("Number of partitions:")
    println(data2.getNumPartitions)

    // If you are decreasing the number of partitions in an RDD, consider using `coalesce`,
    // which can avoid performing a shuffle.
    val data3 = data2.coalesce(2)
    println("Number of partitions:")
    println(data3.getNumPartitions)
  }

}