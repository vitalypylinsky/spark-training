package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class EncoderAppSpec extends FunSpec {

  describe("Encoder App Tests") {

    it("test run") {

      EncoderApp.mainTestable(spark)
    }
  }
}
