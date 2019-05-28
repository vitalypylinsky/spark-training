package com.itechart.spark.sql

import org.apache.spark.sql.SparkSession

object CreateDataFrameApp {

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

    // create a DataFrame using spark.createDataFrame from a List or Seq
    val langPercentDF = spark.createDataFrame(List(("Scala", 35), ("Python", 30), ("R", 15), ("Java", 20)))

    //rename the columns
    val lpDF = langPercentDF.withColumnRenamed("_1", "language")
      .withColumnRenamed("_2", "percent")

    //order the DataFrame in descending order of percentage
    import org.apache.spark.sql.functions.desc
    lpDF.orderBy(desc("percent")).show(false)

    // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
    import spark.implicits._
    val path = "src/main/resources/people.json"
    val peopleDS = spark.read.json(path).as[Person]
    peopleDS.show()

  }

}