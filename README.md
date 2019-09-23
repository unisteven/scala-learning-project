# My journey to learning scala
This document will describe my learning process about a new programming paradigm and language.


## Getting down the basics

In order to get to know the language I'd have to start by gathering information about the basic features of the Scala language.
I'd like to get started with some key concepts such as functions, system functions(print text), loops, arrays and testing.

### Functions

Just like any new programming language or framework the first thing to do is obviously making an `Hello world` program.

```Scala
object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world")
  }
}
```
Opposite to Java it seems you need less syntax in scala to achieve the same functionality. To start you'de first have to define an Object or class. 
Within that Object you can house your functions. Functions are defined by the `def` syntax followed by the name and parameters. 
System functions can be called directly without specifying syntax like `System.*.`. I really like the shorter way of writing these down reducing the amount of syntax needed.

## Returning values in functions
After fiddling with scala for a bit I have found out that scala has a unique way of returning values in functions.

```scala
  def highest(x: Double, y: Double): Double ={
    if (x > y) x else y
  }
```
This function will return an value of the type Double. But note the absence of the `return` statement. In scala it is not required
to write down the return statement but instead you can write down the logic and let it return the value of that logic
one more example:
```Scala
def lowest(x: Double, y: Double): Double = {
    val lowestValue = if (x < y) x else y // this is the scala way of making a ternary statement
    lowestValue // by writing down the value without any other syntax it will return the value.
  }
```

## Higher order functions
### In short what are higher order functions?
A higher order function is able to receive an function as input parameter and or is able to return an function.
### Example
Imagine a function called `math` all this function can do is take three arguments the first is `x` the second is `y` and the third is a `function` This function 
is the operation that has to take place on values `x` and `y`. In this example we will make a function that will return the highest value of the two.
```scala
  def main(args: Array[String]): Unit = {
    print("the max of 10, 99 = " + math(10, 99, highest))
  }

  def math(x: Double, y: Double, operation: (Double, Double) => Double): Double = operation(x, y)

  def highest(x: Double, y: Double): Double ={
    if (x > y) x else y
  }
```

In the example you can see that `highest` is given with as argument for the function `math`. Note that the parameter of `highest` does not have any parentheses.
Adding parentheses will execute the function and will return the result as as value in the argument. By not including the parentheses it will not execute this function as value.
 
## loops
I'm curious to know how to write down loops in scala and how to iterate trough arrays.

Starting with the basic `for i` loop.
```Scala
def countUp(): String ={
    var output: String = ""
    for (i <- 0 to 10){ // you start by defining the variable followed by the range in this case 0 to 10
      output += i + " ";
    }
    output
  }
```
The for loop is written using a `range` in this case 0 to 10. This is a simple and clear way of reading opposite to the way Java formats it `(int i = 0; i < 10; i++)`

### for each loop
In case you have an array of objects or values it is preferred to use a for each loop. IN the following example you can see how to loop trough an array existing of Strings in scala.
```Scala
def printListOfStrings(): String ={
    var output = ""
    val listOfStrings: List[String] = List("first", "second", "last")
    for(s <- listOfStrings){
      output += s
    }
    output
  }
```  
This works just the same as the other for loop example. The first argument `s` is the current value in the list and the second argument is the list that is to be iterated.

### Guards in for loops.
Another cool thing scala has is guards in for loops. In short: A guard is a condition the current value in the array has to meet in order to be iterated trough.
This can be achieved by doing the following:
```Scala
  def printListOfStringsLongerThen(min: Int, list: List[String]): String ={
    var output = ""
    for(s <- list if s.length >= min){
      output += s
    }
    output
  }
```
In this case it will only iterate trough all items in the list that meet the requirement of `s.length >= min` 
The resulting output would be
`All strings longer or equal to 5 characters = firstsecond`
using the following function call:
```Scala
    val list: List[String] = List("first", "second", "last")
    println("All strings longer or equal to 5 characters = " + printListOfStringsLongerThen(5, list))
```

## Extra
It isn't required to write down semicolons.


## References
- https://www.geeksforgeeks.org/higher-order-functions-in-scala/
- https://alvinalexander.com/scala/scala-ternary-operator-syntax


