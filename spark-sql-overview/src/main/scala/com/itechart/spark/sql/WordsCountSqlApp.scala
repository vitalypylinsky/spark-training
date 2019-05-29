package com.itechart.spark.sql

import org.apache.spark.sql.{SaveMode, SparkSession}

object WordsCountSqlApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Words count SQL Application")
      .enableHiveSupport()
      .getOrCreate()

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, age: Long)

  def mainTestable(spark: SparkSession): Unit = {

    // Load the text into a Spark Dataset[String]
    val textFile = spark.read.textFile("src/main/resources/input.txt")

    // converts String objects to and from the Spark SQL row using catalyst expressions and code generation
    import spark.implicits.newStringEncoder
    val wordsDs = textFile.flatMap(_.split(" "))

    wordsDs.createOrReplaceTempView("WORDS")
    val counts = spark.sql("SELECT Value as word, COUNT(Value) as words_count FROM WORDS GROUP BY Value")
      .cache()

    counts.show()

    // save the result as json to FS
    counts.write.mode(SaveMode.Overwrite).format("json").save("output")
    counts.explain(true)
  }

}