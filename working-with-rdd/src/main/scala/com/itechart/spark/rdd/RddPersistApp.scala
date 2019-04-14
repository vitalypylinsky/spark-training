package com.itechart.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RddPersistApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("RDD Persist Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val lastYearsLogs: RDD[String] = spark.parallelize(
      Array(
        "1...INFO...",
        "2...INFO...",
        "3...ERROR...",
        "4...INFO...",
        "5...ERROR..."
      )
    )
    val logsWithErrors = lastYearsLogs.filter(_.contains("ERROR")).persist() // <------------------ persist
    val firstLogWithError = logsWithErrors.take(1)  // action 1
    val numErrors = logsWithErrors.count()                // action 2

    println(firstLogWithError.head)
    println(numErrors)
  }

}