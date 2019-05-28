package com.itechart.spark.sql

import org.apache.spark.sql.{Encoders, SparkSession}

object EncoderApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Simple Application")
      .enableHiveSupport()
      .getOrCreate()

    mainTestable(spark)

    spark.stop()
  }

  case class Person(name: String, age: Long)

  def mainTestable(spark: SparkSession): Unit = {

    import spark.implicits.newIntEncoder
    val ds = spark.createDataset(Seq(1, 2, 3))
    ds.printSchema()                            // |-- value: integer (nullable = false)


    val ds2 = spark.createDataset(Seq(Person("Andy", 32)))(Encoders.product[Person])
    ds2.printSchema()
    // root
    // |-- name: string (nullable = true)
    // |-- age: long (nullable = false)

    // Encoders for most common types are automatically provided by importing spark implicits
    import spark.implicits._                   // implicitly provided (spark.implicits.newProductSeqEncoder)
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()
  }

}