package com.itechart.spark.rdd

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class WordsCountAppSpec extends FunSpec {

  describe("Words Count App Tests") {

    it("test run") {

      WordsCountApp.mainTestable(spark)
    }
  }
}
