package me.unisteven.scala

object Main {

  def main(args: Array[String]): Unit = {
    println("the max of 10, 99 = " + math(10, 99, highest))
    println("the lowest of 10, 99 = " + math(10, 99, lowest))
    println("Counting till from 0 to 10 = " + countUp())
    println("concatenating list = " + printListOfStrings())
    val list: List[String] = List("first", "second", "last")
    println("All strings longer or equal to 5 characters = " + printListOfStringsLongerThen(5, list))
  }

  def math(x: Double, y: Double, operation: (Double, Double) => Double): Double = operation(x, y)

  def highest(x: Double, y: Double): Double = {
    if (x > y) x else y
  }

  def lowest(x: Double, y: Double): Double = {
    val lowestValue = if (x < y) x else y // this is the scala way of making a ternary statement
    lowestValue // by writing down the value without any other syntax it will return the value.
  }

  def countUp(): String ={
    var output: String = ""
    for (i <- 0 to 10){ // you start by defining the variable followed by the range in this case 0 to 10
      output += i + " ";
    }
    output
  }

  def printListOfStrings(): String ={
    var output = ""
    val listOfStrings: List[String] = List("first", "second", "last")
    for(s <- listOfStrings){
      output += s
    }
    output
  }

  def printListOfStringsLongerThen(min: Int, list: List[String]): String ={
    var output = ""
    for(s <- list if s.length >= min){
      output += s
    }
    output
  }


}
