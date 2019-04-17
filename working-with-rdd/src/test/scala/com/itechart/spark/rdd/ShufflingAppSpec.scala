package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ShufflingAppSpec extends FunSpec {

  describe("Pair RDD App Tests") {

    it("test run") {

      ShufflingApp.mainTestable(spark)
    }

    it("test improved run") {

      ShufflingApp.mainTestableImproved(spark)
    }
  }
}
