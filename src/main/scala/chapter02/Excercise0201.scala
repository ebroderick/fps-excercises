package chapter02

object Excercise0201 {

  def fib(num: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, previous: Int, current: Int): Int = {
      if (n == 0) previous
      else loop(n - 1, current, current + previous)
    }

    loop(num, 0, 1)
  }

}


