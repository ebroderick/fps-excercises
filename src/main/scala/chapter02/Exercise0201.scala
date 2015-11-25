package chapter02

import scala.annotation.tailrec

object Exercise0201 {

  def fib(number: Int): Int = {

    @tailrec
    def go(i: Int, prev: Int, current: Int): Int = {
      if (i == 0) prev
      else go(i - 1, current, prev + current)
    }

    go(number, 0, 1)
  }
}


