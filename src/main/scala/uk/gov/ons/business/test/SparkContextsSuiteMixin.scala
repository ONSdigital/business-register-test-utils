package uk.gov.ons.business.test

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfter, Suite}
import uk.gov.ons.business.test.SparkContextsSuiteMixin.config

object SparkContextsSuiteMixin {
  lazy val config = new SparkConf().setAppName("Unit tests").setMaster("local")
}

trait SparkContextsSuiteMixin extends BeforeAndAfter {
  this: Suite =>

  implicit var context: SparkContext = _
  implicit var sqlContext: SQLContext = _

  before {
    context = new SparkContext(config)
    sqlContext = new SQLContext(context)
  }

  after {
    context.stop()
    sqlContext = null
    context = null
  }
}
