package com.itechart.spark.introduction

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

object App {

  private val logger = Logger.getLogger(classOf[App])

  private def parseCommandLineArgs(args: Array[String]): String = {
    if (args.length != 1) {
      logger.error("A file is not specified")
      sys.exit(1)
    }
    args(0)
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("Simple Application")
      .getOrCreate()

    mainTestable(spark, parseCommandLineArgs(args))

    spark.stop()
  }

  def mainTestable(spark: SparkSession, file: String): Unit = {
    val data = spark.read.textFile(file).cache()

    val numAs = data.filter(line => line.contains("a")).count()
    val numBs = data.filter(line => line.contains("b")).count()

    println(s"Lines with a: $numAs, Lines with b: $numBs")
  }

}