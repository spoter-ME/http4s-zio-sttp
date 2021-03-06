package http4s_zio_sttp.persistence

import http4s_zio_sttp.{User, UserNotFound}
import zio.{Ref, Task, ZLayer}

case class Test(users: Ref[Vector[User]]) extends Persistence.Service[User] {
  override def get(id: Int): Task[User] =
    users.get.flatMap(users =>
      Task.require(UserNotFound(id))(Task.succeed(users.find(_.id == id))))
  override def create(user: User): Task[User] =
    users.update(_ :+ user).map(_ => user)
  override def delete(id: Int): Task[Boolean] =
    users.modify(users => true -> users.filterNot(_.id == id))
}

object Test {
  val layer: ZLayer[Any, Nothing, UserPersistence] =
    ZLayer.fromEffect(Ref.make(Vector.empty[User]).map(Test(_)))

}
