package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object BroadcastVarApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Broadcast Variable Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val commonWordsBC = spark.broadcast(
      Array("a", "an", "the", "is", "am", "are", "this", "that", "or", "and", "not", "be", "to")
    )

    val words = spark.textFile("src/main/resources/data/hamlet")
      .flatMap { line =>
        line.split(" ")
          .filterNot(commonWordsBC.value.contains(_))
          .map(_.trim.replaceAll("[^a-zA-Z]",""))
      }

    println(words.collect().toSeq)
  }

}