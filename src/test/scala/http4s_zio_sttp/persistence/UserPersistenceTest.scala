package http4s_zio_sttp.persistence

import http4s_zio_sttp.User
import zio.test.Assertion._
import zio.test._
import zio.test.environment.TestEnvironment

object UserPersistenceTest extends DefaultRunnableSpec {

  def spec =
    suite("Persistence unit test")(
      testM("get a non existing user should fail") {
        assertM(getUser(100).run)(fails(anything))
      },
      testM("create a user then get it ") {
        for {
          created <- createUser(User(14, "usr"))
          user <- getUser(14)
        } yield
          assert(created)(equalTo(User(14, "usr"))) &&
            assert(user)(equalTo(User(14, "usr")))
      },
      testM("delete user") {
        for {
          deleted <- deleteUser(14).either
          notFound <- getUser(14).either
        } yield
          assert(deleted)(isRight(isTrue)) &&
            assert(notFound)(isLeft(anything))
      }
    ).provideSomeLayer[TestEnvironment](Test.layer)
}
