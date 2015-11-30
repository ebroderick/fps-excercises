package chapter03

/**
  * @author brodericke
  */
object Exercise0327 {

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

}
