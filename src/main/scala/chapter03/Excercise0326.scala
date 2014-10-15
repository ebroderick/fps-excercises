package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0326 {

  def max(tree: Tree[Int]): Int = tree match {
      case Leaf(i) => i
      case Branch(left, right) => max(left).max(max(right))
    }

}
