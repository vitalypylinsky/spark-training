package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RangeRddApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val data = spark.range(0, 10)
    data.foreach(println)
  }

}