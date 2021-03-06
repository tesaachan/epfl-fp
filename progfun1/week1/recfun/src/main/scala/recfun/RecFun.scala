package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if c == r || c == 0 then 1 else
      pascal(c-1, r-1) + pascal(c, r-1)
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    def sub(chars: List[Char], blc: Int): Boolean =
      if blc < 0 then false else
        if chars.isEmpty then
          if blc == 0 then true else false
        else if chars.head == '(' then sub(chars.tail, blc + 1)
        else if chars.head == ')' then sub(chars.tail, blc - 1)
        else sub(chars.tail, blc)

    sub(chars, 0)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    def count(rest: Int, coins: List[Int]): Int =
      if rest == 0 then 1 else if rest < 0 then 0 else
      if rest > 0 && coins.isEmpty then  0
      else
        countChange(rest, coins.tail) + countChange(rest - coins.head, coins)

    count(money, coins.sorted(Ordering.Int.reverse))
        
