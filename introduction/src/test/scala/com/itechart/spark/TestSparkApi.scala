package com.itechart.spark

import org.apache.spark.{SparkConf, SparkContext}

object TestSparkApi {

  lazy val spark: SparkContext = {
    new SparkContext(
      new SparkConf()
        .setMaster("local")
        .setAppName("Simple Test Application")
      //.set("spark.eventLog.enabled", "true")
      //.set("spark.eventLog.dir", "tmp/logs")
    )
  }

}
