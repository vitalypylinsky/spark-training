package com.itechart.spark.internals

import org.apache.spark.{SparkConf, SparkContext}

object ParallelizedCollectionWithPartitionApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Parallelized Collection with partition parameter Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {

    val arrayData = spark.parallelize(Array(1, 2, 3, 4, 5))
    println("Number of partitions:")
    println(arrayData.getNumPartitions)

    val arrayData2 = spark.parallelize(Array(1, 2, 3, 4, 5), 16)
    println("Number of partitions:")
    println(arrayData2.getNumPartitions)
  }

}