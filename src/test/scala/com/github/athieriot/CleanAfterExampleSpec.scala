package com.github.athieriot

import org.specs2.mutable.Specification
import reactivemongo.bson.BSONDocument

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class CleanAfterExampleSpec extends Specification with EmbedConnection with MongoInit with CleanAfterExample {

  sequentialyIsolated

  "Embed database" should {
    "be able to save a Model I" in {
      val coll = getColl
      Await.ready(coll.insert(BSONDocument("hello" -> "World")), 1 second)
      Await.result(coll.count(None), 5 second) must be_==(1)
    }

    "be able to save a Model II" in {
      val coll = getColl
      Await.ready(coll.insert(BSONDocument("hello" -> "World")), 1 second)
      Await.result(coll.count(None), 5 second) must be_==(1)
    }

    "be able to save a Model III" in {
      val coll = getColl
      Await.ready(coll.insert(BSONDocument("hello" -> "World")), 1 second)
      Await.result(coll.count(None), 5 second) must be_==(1)
    }

    "be able to save a Model IV" in {
      val coll = getColl
      Await.ready(coll.insert(BSONDocument("hello" -> "World")), 1 second)
      Await.result(coll.count(None), 5 second) must be_==(1)
    }

    "be able to save a Model V" in {
      val coll = getColl
      Await.ready(coll.insert(BSONDocument("hello" -> "World")), 1 second)
      Await.result(coll.count(None), 5 second) must be_==(1)
    }
  }
}