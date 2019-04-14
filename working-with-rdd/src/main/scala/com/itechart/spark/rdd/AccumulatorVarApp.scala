package com.itechart.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorVarApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Accumulator Variable Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val accum = spark.longAccumulator("My Accumulator")

    spark.parallelize(Array(1, 2, 3, 4)).foreach(x => accum.add(x))

    println(accum.value)
  }

}