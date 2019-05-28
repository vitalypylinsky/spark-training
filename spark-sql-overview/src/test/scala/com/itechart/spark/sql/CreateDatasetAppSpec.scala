package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class CreateDatasetAppSpec extends FunSpec {

  describe("Create Dataset App Tests") {

    it("test run") {

      CreateDatasetApp.mainTestable(spark)
    }
  }
}
