package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class SparkSessionAppSpec extends FunSpec {

  describe("Spark Session App Tests") {

    it("test run") {

      SparkSessionApp.mainTestable(spark)
    }
  }
}
