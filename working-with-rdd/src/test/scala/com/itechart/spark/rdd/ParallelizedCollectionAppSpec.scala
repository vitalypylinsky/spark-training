package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ParallelizedCollectionAppSpec extends FunSpec {

  describe("Range RDD App Tests") {

    it("test run") {

      ParallelizedCollectionApp.mainTestable(spark)
    }
  }
}
