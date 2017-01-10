package com.github.athieriot

import org.specs2.mutable.Specification
import reactivemongo.bson.BSONDocument

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
class EmbedConnectionSpec extends Specification with EmbedConnection with MongoInit {
  sequential

  "Embed database" should {
    "be able to save a Model I" in {
      val futureCount = for {
        coll <- getColl
        res <- coll.insert(BSONDocument("hello" -> "World"))
        count <- coll.count()
      } yield count

      Await.result(futureCount, 5 second) must be_==(1)
    }

    "be able to save a Model II" in {
      val futureCount = for {
        coll <- getColl
        res <- coll.insert(BSONDocument("hello" -> "World"))
        count <- coll.count()
      } yield count

      Await.result(futureCount, 5 second) must be_==(2)
    }

    "be able to save a Model III" in {
      val futureCount = for {
        coll <- getColl
        res <- coll.insert(BSONDocument("hello" -> "World"))
        count <- coll.count()
      } yield count

      Await.result(futureCount, 5 second) must be_==(3)
    }

    "be able to save a Model IV" in {
      val futureCount = for {
        coll <- getColl
        res <- coll.insert(BSONDocument("hello" -> "World"))
        count <- coll.count()
      } yield count

      Await.result(futureCount, 5 second) must be_==(4)
    }

    "be able to save a Model V" in {
      val futureCount = for {
        coll <- getColl
        res <- coll.insert(BSONDocument("hello" -> "World"))
        count <- coll.count()
      } yield count

      Await.result(futureCount, 5 second) must be_==(5)
    }
  }
}

