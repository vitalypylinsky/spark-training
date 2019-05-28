package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class CreateDataFrameAppSpec extends FunSpec {

  describe("Create DataFrame App Tests") {

    it("test run") {

      CreateDataFrameApp.mainTestable(spark)
    }
  }
}
