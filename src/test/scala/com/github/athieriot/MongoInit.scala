package com.github.athieriot

import reactivemongo.api.MongoDriver
import reactivemongo.api.collections.bson.BSONCollection
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

trait MongoInit {
  def getColl: Future[BSONCollection] = {
    val driver = new MongoDriver
    val conn = driver.connection(List("localhost:12345"))
    conn.database("testdb").map(
      _.collection("testcoll"))
  }
}
