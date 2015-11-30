package chapter03

/**
  * @author brodericke
  */
object Exercise0326 {

  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(x) => x
    case Branch(l, r) => maximum(l) max maximum(r)
  }

}
