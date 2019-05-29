package com.itechart.spark.sql

import org.apache.spark.sql.{SaveMode, SparkSession}

object WordsCountApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Words count Application")
      .enableHiveSupport()
      .getOrCreate()

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, age: Long)

  def mainTestable(spark: SparkSession): Unit = {

    // Load the text into a Spark Dataset[String]
    import spark.implicits._
    val textFile = spark.read.textFile("src/main/resources/input.txt")
    // root
    // |-- value: string (nullable = true)

    // converts String objects to and from the Spark SQL row using catalyst expressions and code generation
    val wordsDs = textFile.flatMap(_.split(" "))
    val counts = wordsDs.groupBy("value").count().cache()

    counts.show()

    // save the result as csv to FS
    counts.write.mode(SaveMode.Overwrite).format("csv").save("output")
    counts.explain()

  }

}