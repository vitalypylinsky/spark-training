package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object ExternalSourceApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, surname: String)

  def mainTestable(spark: SparkContext): Unit = {
    val hamlet = spark.textFile("src/main/resources/data/hamlet")
    val linesCount = hamlet.count()
    println(linesCount)
  }

}