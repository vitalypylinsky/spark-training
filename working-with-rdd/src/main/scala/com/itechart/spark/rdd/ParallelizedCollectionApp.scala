package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object ParallelizedCollectionApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val arrayData = spark.parallelize(Array(1, 2, 3, 4, 5))
    arrayData.foreach(println)
    println("Number of partitions:")
    println(arrayData.getNumPartitions)

    val rangeData = spark.range(0, 5)
    rangeData.foreach(println)
  }

}