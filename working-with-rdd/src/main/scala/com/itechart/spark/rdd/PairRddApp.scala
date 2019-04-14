package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object PairRddApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Pair RDD Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val lines = spark.textFile("src/main/resources/data/lines.txt")
    val pairs = lines.map(s => (s, 1)).cache()

    val counts = pairs.groupByKey().map(t => (t._1, t._2.sum))
    println(counts.collectAsMap())

    val counts2 = pairs.reduceByKey((a, b) => a + b)
    println(counts2.collectAsMap())
  }

}