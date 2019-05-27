package com.itechart.spark.sql

import org.apache.spark.sql.SparkSession

object SparkSessionApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Simple Application")
      .enableHiveSupport()
      .getOrCreate()

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkSession): Unit = {

    val myRange = spark.range(100) // Dataset[Long]
      .toDF("number") // This range of number represents a distributed collection

    myRange.foreach(println(_))
  }

}