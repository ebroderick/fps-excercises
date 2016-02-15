package chapter10


/**
  * Created by ebroderick on 2/10/16.
  */
object Exercise1006 {
  def foldRightViaFoldMap[A, B](b: B, l: List[A])(f: (A, B) => B) = {
    //Exercise1005.foldMap(l, Exercise1003.endoMonoid[B])(a => f(a, _))
    Exercise1005.foldMap(l, Exercise1003.endoMonoid[B])(f.curried)
  }
}
