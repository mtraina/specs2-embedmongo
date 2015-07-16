package com.github.athieriot

import reactivemongo.api.MongoDriver
import reactivemongo.api.collections.bson.BSONCollection
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

trait MongoInit {
  def getColl: BSONCollection =  {
    val driver = new MongoDriver
    val db = driver.connection(List("localhost:12345"))("testdb")
    Await.ready(db.connection.waitForPrimary(10 seconds), 11 seconds)
    db("testcoll")
  }
}
