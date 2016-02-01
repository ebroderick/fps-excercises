import java.util.concurrent.TimeUnit

/**
  * Created by ebroderick on 1/29/16.
  */
package object chapter07 {

  class ExecutorService {
    def submit[A](a: Callable[A]): Future[A] = {
      println("callable submitted to executorService")
      UnitFuture(a.call)
    }
  }

  trait Callable[A] {
    def call: A
  }

  trait Future[A] {
    def get: A
    def get(timeout: Long, unit: TimeUnit): A
    def cancel(evenIfRunning: Boolean): Boolean
    def isDone: Boolean
    def isCancelled: Boolean
  }

  case class UnitFuture[A](get: A) extends Future[A] {
    override def get(timeout: Long, unit: TimeUnit): A = get
    override def isCancelled: Boolean = false
    override def cancel(evenIfRunning: Boolean): Boolean = false
    override def isDone: Boolean = true
  }

}
