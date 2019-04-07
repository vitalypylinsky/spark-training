package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ExtSourceAppSpec extends FunSpec {

  describe("External Source App Tests") {

    it("test run") {

      ExtSourceApp.mainTestable(spark)
    }
  }
}
