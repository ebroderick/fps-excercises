package chapter03

object Exercise0320 {

  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] =
    //List.foldLeft(as, List[B]())((b, a) => List.foldLeft(f(a), b)((b2, a2) => Exercise0314.append(b2, a2)))
    Exercise0315.concat(Exercise0318.map(as)(f))
}


