package com.itechart.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ParallelizedCollectionApp {

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, surname: String)

  def mainTestable(spark: SparkContext): Unit = {
    val arrayData = spark.parallelize(Array(1, 2, 3, 4, 5))
    arrayData.foreach(println) // action
    println("Number of partitions:")
    println(arrayData.getNumPartitions)

    val rangeData = spark.range(0, 5)
    rangeData.foreach(println) // action

    val tupleData: RDD[(String, Long)] = spark.parallelize(
      Seq(("a", 1), ("c", 2))
    )
    tupleData.foreach(println)

    val caseClassData: RDD[Person] = spark.parallelize(
      Seq(Person("n1", "s1"), Person("n2", "s2"))
    )
    caseClassData.foreach(println)
  }

}