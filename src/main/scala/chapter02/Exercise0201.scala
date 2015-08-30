package chapter02

import scala.annotation.tailrec

object Exercise0201 {

  def fib(num: Int): Int = {
    @tailrec
    def go(count: Int, prev1: Int, prev2: Int): Int = {
      if (count == 0)
        prev2
      else
        go(count - 1, prev1 + prev2, prev1)
    }
    go(num, 1, 0)
  }

  def fib2(num: Int): Int = {
    if (num == 0) 0
    else if (num == 1) 1
    else fib2(num - 1) + fib2(num - 2)
  }

  def fib3(num: Int): Int = {
    @tailrec
    def go(count: Int, prev1: Int, prev2: Int): Int = {
      if (count == num)
        prev1 + prev2
      else
        go(count + 1, prev1 + prev2, prev1)
    }

    if (num == 0) 0
    else if (num == 1) 1
    else go(2, 1, 0)
  }
}


