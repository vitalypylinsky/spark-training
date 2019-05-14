package com.itechart.spark.internals

import com.itechart.spark.TestSparkApi.spark
import org.scalatest.FunSpec

class RepartitionAppSpec extends FunSpec {

  describe("Repartition App Tests") {

    it("test run") {

      RepartitionApp.mainTestable(spark)
    }
  }
}
