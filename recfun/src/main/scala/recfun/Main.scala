package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(countChange(11,List(1,5)))
    println(balance(List('(',')','(','(','a','b',')','(',')',')')))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c-1,r-1)+pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def subBalance(chars: List[Char], openParen: Int): Boolean = {
        if (chars.isEmpty) (openParen == 0)
        else
          if (chars.head == '(') subBalance(chars.tail, openParen+1)
          else
            if (chars.head == ')') (openParen > 0 && subBalance(chars.tail,openParen-1))
            else subBalance(chars.tail, openParen)
      }
      subBalance(chars, 0)
  }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0) 0
      else if (coins.isEmpty) 0
      else if (money == 0) 1
      else countChange(money-coins.head,coins) + countChange(money,coins.tail)
    }
  }
