package com.itechart.spark.internals

import org.apache.spark.{SparkConf, SparkContext}

object ExecutionModelImprovedApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Execution Model Improved Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {

    // Load the text into a Spark RDD from the names folder
    val rdd = spark.textFile("src/main/resources/data/names")
      .distinct(numPartitions = 6)
      .map(name => (name.charAt(0), 1))
      .reduceByKey(_ + _)

    println(rdd.partitions.length)
    rdd.collect().foreach(println)
  }

}