package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class RddOperationsAppSpec extends FunSpec {

  describe("RDD Operations App Tests") {

    it("test run") {

      RddOperationsApp.mainTestable(spark)
    }
  }
}
