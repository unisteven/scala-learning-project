package me.unisteven.scala
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.concurrent.{ExecutionContext, Future}

object Main {

  def main(args: Array[String]): Unit = {
    println("the max of 10, 99 = " + math(10, 99, highest))
    println("the lowest of 10, 99 = " + math(10, 99, lowest))
    println("Counting till from 0 to 10 = " + countUp())
    println("concatenating list = " + printListOfStrings())
    val list: List[String] = List("first", "second", "last")
    println("All strings longer or equal to 5 characters = " + printListOfStringsLongerThen(5, list))
    canArraysIncreaseInSize()
    createAListOfNumbers()
    fillArrayBuffer()
    fillListBuffer()
    fillBasketWithFruitString()
    println("lets wait for....")
//    val f = Future {
//      letsWait(2)
//    }
    println("I'm done waiting")
  }

  def math(x: Double, y: Double, operation: (Double, Double) => Double): Double = operation(x, y)

  def highest(x: Double, y: Double): Double = {
    if (x > y) x else y
  }

  def lowest(x: Double, y: Double): Double = {
    val lowestValue = if (x < y) x else y // this is the scala way of making a ternary statement
    lowestValue // by writing down the value without any other syntax it will return the value.
  }

  def countUp(): String = {
    var output: String = ""
    for (i <- 0 to 10) { // you start by defining the variable followed by the range in this case 0 to 10
      output += i + " ";
    }
    output
  }

  def printListOfStrings(): String = {
    var output = ""
    val listOfStrings: List[String] = List("first", "second", "last")
    for (s <- listOfStrings) {
      output += s
    }
    output
  }

  def printListOfStringsLongerThen(min: Int, list: List[String]): String = {
    var output = ""
    for (s <- list if s.length >= min) {
      output += s
    }
    output
  }

  def canArraysIncreaseInSize(): Unit = {
    //    val ar = Array(1)
    //    for(i <- 0 to 10){
    //      ar(i) = 1
    //    }
    //    println(ar)
  }

  def createAListOfNumbers(): Unit = {
    var numbers: List[Int] = List()
    for (i <- 0 to 10) {
      numbers = i :: numbers // the :: will 'add' an item to the list by replacing the entire list with a new list.
    }
    println(numbers)
  }


  def fillArrayBuffer(): Unit = {
    var buf: ArrayBuffer[Int] = ArrayBuffer() // this is an arrayBuffer for the type of Int
    for (i <- 0 to 10) {
      buf += i
    }
    println(buf)
  }

  def fillListBuffer(): Unit = {
    var buf: ListBuffer[Int] = ListBuffer();
    for (i <- 0 to 10) {
      buf += i
    }
    println(buf)
  }

  def fillBasketWithFruitString(): Unit = {
    val basket = new Basket[String]
    basket.setItem("Apple")
    println("the basket is holding: " + basket.getItem())
  }

  def letsWait(seconds: Int): Unit = {
    Thread.sleep(seconds * 1000)
  }

}


