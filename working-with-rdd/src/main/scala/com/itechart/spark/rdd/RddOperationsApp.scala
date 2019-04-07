package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RddOperationsApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val lines = spark.textFile("src/main/resources/data/hamlet")
    val lineLengths = lines.map(s => s.length)
    val totalLength = lineLengths.reduce((a, b) => a + b)
    println(totalLength)


    val arrayData1 = spark.parallelize(Array(1, 2, 3, 4, 5))
    val arrayData2 = spark.parallelize(Array(3, 4, 5, 6, 7))

    arrayData1.intersection(arrayData2).foreach(println)
  }

}