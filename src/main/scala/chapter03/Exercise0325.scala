package chapter03

/**
  * @author brodericke
  */
object Exercise0325 {

  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

}
