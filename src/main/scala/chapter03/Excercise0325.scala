package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0325 {

  def size[A](tree: Tree[A]): Int = {
    tree match {
      case Leaf(v) => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }
}
