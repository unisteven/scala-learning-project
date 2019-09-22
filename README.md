# My journey to learning scala
This document will describe my learning process about learning a new programming paradigm and language.


## Getting down the basics

In order to get to know the language i'd have to start by gathering information about the basic features of the Scala language.
I'd like to get started with some key concepts such as functions, system functions(print text), loops, arrays and testing.

###Functions

just like any new programming language or framework the first thing to do is obviously making an `Hello world` program.

```Scala
object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world")
  }
}
```
Opposite to Java it seems scala writes down the notion with less syntax. To start you'de first have to define an Object or class. 
Withing that Object you can house your functions. Functions are defined by the `def` syntax followed by the name and parameters. 
System functions can be called directly without specifying syntax like `System.*.`. I really like the shorter way of writing these down reducing the amount of syntax needed to read.

##Returning values in functions
After fiddling with scala for a bit I have found out that scala has a unique way of returning values in functions.

```scala
  def highest(x: Double, y: Double): Double ={
    if (x > y) x else y
  }
```
This function will return an value of the type Double. but note the absence of the `return` statement. In scala it is not required
to write down the return statement but instead you can write the logic and let it return the value of that logic
one more example:
```Scala
def lowest(x: Double, y: Double): Double = {
    val lowestValue = if (x < y) x else y // this is the scala way of making a ternary statement
    lowestValue // by writing down the value without any other syntax it will return the value.
  }
```

## Higher order functions
###In short what are higher order functions?
A higher order function is able to receive an function as input parameter and or is able to return an function.
###Example
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
 


##Extra
It isn't required to write down semicolons.


## References
- https://www.geeksforgeeks.org/higher-order-functions-in-scala/



