package com.itechart.spark.internals

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ExecutionModelAppSpec extends FunSpec {

  describe("Execution Model App Tests") {

    it("test run") {

      ExecutionModelApp.mainTestable(spark)
    }
  }
}
