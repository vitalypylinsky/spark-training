package com.itechart.spark.sql

import org.apache.spark.sql.SparkSession

object CreateDatasetApp {

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

    //create a Dataset using spark.range starting from 5 to 100, with increments of 5
    val numDS = spark.range(5, 100, 5)

    //compute descriptive stats and display them
    numDS.describe().show()

    // reverse the order and display first 5 items
    import org.apache.spark.sql.functions.desc
    val ordNumDS = numDS.orderBy(desc("id"))
    ordNumDS.show(5)

    ordNumDS.explain()
  }

}