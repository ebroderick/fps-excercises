package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0328 {

  def map[A, B](tree: Tree[A], f: (A) => B): Tree[B] = {
    tree match {
      case Leaf(a) => Leaf(f(a))
      case Branch(l, r) => Branch(map(l, f), map(r, f))
    }
  }

}
