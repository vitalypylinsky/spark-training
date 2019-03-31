package com.itechart.spark.introduction

import org.scalatest.FunSpec
import com.itechart.spark.TestSparkApi.spark

class AppSpec extends FunSpec {

  describe("App Tests") {

    it("test run") {

      App.mainTestable(spark, "src/test/resources/data/SPARK_2_4_0_README.md")
    }
  }
}
