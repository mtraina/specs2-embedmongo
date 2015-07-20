package com.github.athieriot

import org.specs2.specification.AfterEach
import reactivemongo.api.MongoDriver

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

trait CleanAfterExample extends AfterEach {
  self: EmbedConnection =>

  def getConn = {
    val driver = new MongoDriver
    val db = driver.connection(List(s"127.0.0.1:${network.getPort}"))("testdb")
    Await.ready(db.connection.waitForPrimary(10 seconds), 11 seconds)
    db
  }

  def after = {
    Await.ready(getConn.drop(), 1 second)
  }

}