package com.itechart.spark.internals

import org.apache.spark.{SparkConf, SparkContext}

object RddLineageApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("RDD Lineage Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  def mainTestable(spark: SparkContext): Unit = {
    val r00 = spark.parallelize(0 to 9)
    val r01 = spark.parallelize(0 to 90 by 10)
    val r10 = r00 cartesian r01
    val r11 = r00.map(n => (n, n))
    val r12 = r00 zip r01
    val r13 = r01.keyBy(_ / 20)
    val r20 = Seq(r11, r12, r13).foldLeft(r10)(_ union _)

    println(r20.toDebugString)
    println(r20.getNumPartitions)
    // no computation until action is triggered

    println(r20.collectAsMap())

  }

}
