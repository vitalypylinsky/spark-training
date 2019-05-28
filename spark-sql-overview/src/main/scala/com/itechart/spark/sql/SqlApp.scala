package com.itechart.spark.sql

import org.apache.spark.sql.SparkSession

object SqlApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Simple Application")
      .enableHiveSupport()
      .getOrCreate()

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, age: Long)

  def mainTestable(spark: SparkSession): Unit = {

    val path = "src/main/resources/people.json"
    val peopleDS = spark.read.json(path)
    peopleDS.show()

    // Register the DataFrame as a SQL temporary view
    peopleDS.createOrReplaceTempView("people")

    val sqlDF = spark.sql("SELECT * FROM people")
    sqlDF.show()
  }

}