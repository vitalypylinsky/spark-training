package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class WordsCountAppSpec extends FunSpec {

  describe("Words Count App Tests") {

    it("test run") {

      WordsCountApp.mainTestable(spark)
    }
  }
}
