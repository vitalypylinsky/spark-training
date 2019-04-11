package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object ExtSourceApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("External Source Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val hamlet = spark.textFile("src/main/resources/data/hamlet")
    val linesCount = hamlet.count()
    println(linesCount)
  }

}