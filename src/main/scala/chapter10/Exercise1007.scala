package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/10/16.
  */
object Exercise1007 {
  def foldMapV[A, B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
    if (v.length > 1) {
      val (v1, v2) = v.splitAt(v.length / 2)
      m.op(foldMapV(v1, m)(f), foldMapV(v2, m)(f))
    } else if (v.length == 1) {
      f(v(0))
    } else {
      m.zero
    }
  }
}
