package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class BroadcastVarAppSpec extends FunSpec {

  describe("Broadcast Variable App Tests") {

    it("test run") {

      BroadcastVarApp.mainTestable(spark)
    }
  }
}
