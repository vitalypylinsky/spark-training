package com.itechart.spark.sql

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class SqlAppSpec extends FunSpec {

  describe("SQL App Tests") {

    it("test run") {

      SqlApp.mainTestable(spark)
    }
  }
}
