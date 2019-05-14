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

    // Internally, this uses a shuffle to redistribute data.
    val arrayData3 = arrayData2.repartition(32)
    println("Number of partitions:")
    println(arrayData3.getNumPartitions)

    // If you are decreasing the number of partitions in an RDD, consider using `coalesce`,
    // which can avoid performing a shuffle.
    val arrayData4 = arrayData3.coalesce(2)
    println("Number of partitions:")
    println(arrayData4.getNumPartitions)
  }

}