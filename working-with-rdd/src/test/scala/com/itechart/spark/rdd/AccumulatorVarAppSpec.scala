package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class AccumulatorVarAppSpec extends FunSpec {

  describe("Accumulator Variable App Tests") {

    it("test run") {

      AccumulatorVarApp.mainTestable(spark)
    }
  }
}
