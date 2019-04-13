package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object PassingFunctionsApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Passing Functions Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  class Counter(spark: SparkContext) {

    private val pairs = spark.textFile("src/main/resources/data/lines.txt").map(s => (s, 1)).cache()

    def countLines1(): Map[String, Int] = {
      pairs.reduceByKey((a, b) => a + b)
        .collectAsMap().toMap
    }

    def countLines2(): Map[String, Int] = {
      pairs.reduceByKey(Counter.sumByKey)
        .collectAsMap().toMap
    }

    def countLines3(): Map[String, Int] = {
      pairs.reduceByKey(this.sumByKey)
        .collectAsMap().toMap
    }

    def sumByKey(n1: Int, n2: Int): Int = n1 + n2
  }

  object Counter {
    def sumByKey(n1: Int, n2: Int): Int = n1 + n2
  }

  def mainTestable(spark: SparkContext): Unit = {
    val counter = new Counter(spark)
    println(counter.countLines1())
    println(counter.countLines2())
    //println(counter.countLines3())  // requires extending Serializable
  }

}