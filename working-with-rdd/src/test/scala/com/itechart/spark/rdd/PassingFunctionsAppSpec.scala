package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class PassingFunctionsAppSpec extends FunSpec {

  describe("Passing Functions App Tests") {

    it("test run") {

      PassingFunctionsApp.mainTestable(spark)
    }
  }
}
