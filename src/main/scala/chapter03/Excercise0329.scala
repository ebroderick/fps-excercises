package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0329 {

  def size[A](tree: Tree[A]): Int = {
    tree match {
      case Leaf(v) => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }

  def max(tree: Tree[Int]): Int = tree match {
    case Leaf(i) => i
    case Branch(left, right) => max(left).max(max(right))
  }

  def depth(tree: Tree[Int]): Int = tree match {
    case Leaf(i) => 1
    case Branch(left, right) => (1 + depth(left)).max((1 + depth(right)))
  }

  def map[A, B](tree: Tree[A], f: (A) => B): Tree[B] = {
    tree match {
      case Leaf(a) => Leaf(f(a))
      case Branch(l, r) => Branch(map(l, f), map(r, f))
    }
  }

  def fold[A, B](tree: Tree[A], leafF: (A) => B, branchF: (B, B) => B): B = {
    tree match {
      case Leaf(a) => leafF(a)
      case Branch(l, r) => branchF(fold(l, leafF, branchF), fold(r, leafF, branchF))
    }
  }

  def sizeWithFold[A](tree: Tree[A]) = {
    fold(tree, ((i: A) => 1), ((b1: Int, b2: Int) => 1 + b1 + b2))
  }

  def maxWithFold(tree: Tree[Int]) = {
    fold(tree, ((i: Int) => i), ((b1: Int, b2: Int) => b1.max(b2)))
  }

  def depthWithFold[A](tree: Tree[A]) = {
    fold(tree, ((i: A) => 1), ((b1: Int, b2: Int) => (1 + b1).max(1 + b2)))
  }

  def mapWithFold[A,B](tree: Tree[A])(f: (A) => B): Tree[B] = {
    fold(tree, ((i: A) => Leaf(f(i))), ((b1: Tree[B], b2: Tree[B]) => Branch(b1, b2)))
  }
}
