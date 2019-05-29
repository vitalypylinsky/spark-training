package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class WordsCountSqlAppSpec extends FunSpec {

  describe("Words Count SQL App Tests") {

    it("test run") {

      WordsCountSqlApp.mainTestable(spark)
    }
  }
}
