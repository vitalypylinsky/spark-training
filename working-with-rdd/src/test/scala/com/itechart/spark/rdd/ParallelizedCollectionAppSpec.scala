package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ParallelizedCollectionAppSpec extends FunSpec {

  describe("Parallelized Collection App Tests") {

    it("test run") {

      ParallelizedCollectionApp.mainTestable(spark)
    }
  }
}
