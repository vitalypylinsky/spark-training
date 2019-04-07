package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class PairRddAppSpec extends FunSpec {

  describe("Pair RDD App Tests") {

    it("test run") {

      PairRddApp.mainTestable(spark)
    }
  }
}
