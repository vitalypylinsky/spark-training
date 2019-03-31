package com.itechart.spark

import org.apache.spark.sql.SparkSession

object TestSparkApi {

  lazy val spark: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("Simple Test Application")
      .config("spark.eventLog.enabled", "true")
      .config("spark.eventLog.dir", "./tmp/logs")
      .getOrCreate()
  }

}
