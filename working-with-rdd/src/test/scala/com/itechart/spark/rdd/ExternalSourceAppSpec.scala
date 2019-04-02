package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ExternalSourceAppSpec extends FunSpec {

  describe("Eternal Source App Tests") {

    it("test run") {

      ExternalSourceApp.mainTestable(spark)
    }
  }
}
