package com.itechart.spark.internals

import org.apache.spark.{SparkConf, SparkContext}

object ExecutionModelApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Execution Model Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {

    // Load the text into a Spark RDD from the names folder
    val rdd = spark.textFile("src/main/resources/data/names")
      .map(name => (name.charAt(0), name))
      .groupByKey()
      .mapValues(names => names.toSet.size)

    println(rdd.partitions.length)
    rdd.collect().foreach(println)
  }

}