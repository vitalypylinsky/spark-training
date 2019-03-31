package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import com.itechart.spark.rdd.App.ArgumentsHolder
import org.scalatest.FunSpec

class AppSpec extends FunSpec {

  describe("App Tests") {

    it("test run") {

      App.mainTestable(spark, ArgumentsHolder("src/test/resources/data/SPARK_2_4_0_README.md"))
    }
  }
}
