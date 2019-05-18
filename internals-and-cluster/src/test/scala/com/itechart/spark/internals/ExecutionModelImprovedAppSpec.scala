package com.itechart.spark.internals

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class ExecutionModelImprovedAppSpec extends FunSpec {

  describe("Execution Model Improved App Tests") {

    it("test run") {

      ExecutionModelImprovedApp.mainTestable(spark)
    }
  }
}
