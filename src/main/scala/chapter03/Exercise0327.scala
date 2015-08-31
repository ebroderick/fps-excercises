package chapter03

object Exercise0327 {

  def depth[A](t: Tree[Int]): Int = t match {
    case Leaf(_) => 1
    case Branch(lt, rt) =>
      val lDepth = 1 + depth(lt)
      val rDepth = 1 + depth(rt)
      if (lDepth < rDepth) rDepth else lDepth
  }
}


