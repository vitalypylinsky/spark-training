package com.itechart.spark.rdd

import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}

object App {

  private val logger = Logger.getLogger(classOf[App])

  case class ArgumentsHolder(file: String = ".")

  private def parseCommandLineArgs(args: Array[String]): ArgumentsHolder = {
    val parser = new scopt.OptionParser[ArgumentsHolder]("scopt") {
      opt[String]('f', "file") required() action { (x, h) =>
        h.copy(file = x)
      } text "specifies the input file"
    }

    parser.parse(args, ArgumentsHolder()) match {
      case Some(options) => options
      case None => sys.exit(1)
    }
  }

  def main(args: Array[String]): Unit = {
    val spark = new SparkContext(
      new SparkConf()
        .setAppName("Simple Application")
    )

    mainTestable(spark, parseCommandLineArgs(args))

    spark.stop()
  }

  def mainTestable(spark: SparkContext, args: ArgumentsHolder): Unit = {
    val data = spark.textFile(args.file).cache()

    val numAs = data.filter(line => line.contains("a")).count()
    val numBs = data.filter(line => line.contains("b")).count()

    println(s"Lines with a: $numAs, Lines with b: $numBs")
  }

}