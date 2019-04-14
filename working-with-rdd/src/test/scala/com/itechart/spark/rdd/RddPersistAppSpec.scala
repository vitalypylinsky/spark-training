package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class RddPersistAppSpec extends FunSpec {

  describe("Rdd Persist App Tests") {

    it("test run") {

      RddPersistApp.mainTestable(spark)
    }
  }
}
