package chapter03

object Exercise0326 {

  def maximum[A](t: Tree[Int]): Int = t match {
    case Leaf(i) => i
    case Branch(lt, rt) => maximum(lt) max maximum(rt)
  }
}


