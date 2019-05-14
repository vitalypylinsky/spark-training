package com.itechart.spark.internals

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ParallelizedCollectionWithPartitionAppSpec extends FunSpec {

  describe("Parallelized Collection with partition parameter App Tests") {

    it("test run") {

      ParallelizedCollectionWithPartitionApp.mainTestable(spark)
    }
  }
}
