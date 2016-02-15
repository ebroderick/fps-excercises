package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/12/16.
  */
object MapMergeMonoid {

  def mapMergeMonoid[K, V](V: Monoid[V]): Monoid[Map[K, V]] = new Monoid[Map[K, V]] {
      def op(a: Map[K, V], b: Map[K, V]): Map[K, V] = {
        val keys = a.keySet ++ b.keySet
        keys.foldLeft(zero)((acc, k) => {
          acc.updated(k, V.op(a.getOrElse(k, V.zero), b.getOrElse(k, V.zero)))
        })
      }
      def zero: Map[K, V] = Map[K, V]()
    }

  def main(args: Array[String]) {
    val m: Monoid[Map[String, Int]] = mapMergeMonoid(Exercise1001.intAddition)

    val map1 = Map("k1" -> 3, "k2" -> 4, "k3" -> 5)
    val map2 = Map("k1" -> 3, "k2" -> 4, "k4" -> 1)

    println(m.op(map1, map2))
  }
}
