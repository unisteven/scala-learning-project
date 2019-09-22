package me.unisteven.scala

object Main {

  def main(args: Array[String]): Unit = {
    println("the max of 10, 99 = " + math(10, 99, highest))
    println("the lowest of 10, 99 = " + math(10, 99, lowest))
  }

  def math(x: Double, y: Double, operation: (Double, Double) => Double): Double = operation(x, y)

  def highest(x: Double, y: Double): Double = {
    if (x > y) x else y
  }

  def lowest(x: Double, y: Double): Double = {
    val lowestValue = if (x < y) x else y // this is the scala way of making a ternary statement
    lowestValue // by writing down the value without any other syntax it will return the value.
  }


}
