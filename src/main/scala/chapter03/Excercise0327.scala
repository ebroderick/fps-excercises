package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0327 {

  def depth(tree: Tree[Int]): Int = tree match {
      case Leaf(i) => 1
      case Branch(left, right) => (1 + depth(left)).max((1 + depth(right)))
    }

}
