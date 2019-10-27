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

### Lists
During the process of learning how to use loops and for each loops I came across Lists, this made me curious what implementation 
scala uses for a collection of items. Are there arrays? if so are they a fixed size or variable like an `ArrayList`? These are questions that come up as soon 
as I think about Lists.

### Are there arrays? (like Java)
In scala an array is created by using the `Array(size)` syntax.  Arrays are fixed in size and can throw an Index out of bounds exception
demonstrated by the following code
```Scala
  def canArraysIncreaseInSize(): Unit ={
    val ar = Array(1)
    for(i <- 0 to 10){
      ar(i) = 1
    }
    println(ar)
  }
```
Opposite to Java in Scala you define an array by using parentheses `()` instead of square brackets `[]`. the same goes for setting the value at a certain index.

### Lists
What I have found out in the previous chapter about `for each loops` is that Scala has Lists.
Lists are just as simple to implement as an Array
```Scala
  def createAListOfNumbers(): Unit ={
    var numbers: List[Int] = List()
    for(i <- 0 to 10){
      numbers = i :: numbers // the :: will 'add' an item to the list by replacing the entire list with a new list.
    }
    println(numbers)
  }
```
However the problem with Lists is the same as with arrays. Lists are immutable thus making it impossible to add items. A way to overcome this is by overwriting the entire list with a new list plus one new
item. But this is a expensive operation `O(N)`.  the `::` operator can be used to create a new list that will add the item in.
A List is the implementation of a linked list in scala.

### Mutable collection (ArrayList)
In java the mutable variant of an array is the ArrayList. This list houses an ordinary array under the surface that can increase its size as soon as more items will be added to the array. Scala has the `ArrayBuffer` Implementation that does exactly the same.
Scala also has the `ListBuffer` that will use an linkedList underneath the surface. The `ListBuffer` is useful for when you are planning on converting the ListBuffer to an immutable `List` later on.

The implementation of the ArrayBuffer: 
```Scala
  def fillArrayBuffer(): Unit ={
    var buf: ArrayBuffer[Int] = ArrayBuffer() // this is an arrayBuffer for the type of Int
    for(i <- 0 to 10){
      buf += i
    }
    println(buf)
  }
```

The implementation of the ListBuffer:
```Scala
def fillListBuffer(): Unit ={
    var buf: ListBuffer[Int] = ListBuffer();
    for(i <- 0 to 10){
      buf += i
    }
    println(buf)
  }
```

## Generics
After playing a bit with the Lists I found out that in order to use the list I'd have to specify the type of the var.
```Scala
var buf: ListBuffer[Int] = ListBuffer();
```
In the square brackets `[]` I specified the type. This looks like a generic implementation to me, so I'd like to figure out how I could make my own generics
In my example I will make an basket, this basket is capable of holding one item of any type.

the class:
```Scala
class Basket[T] {
  private var item: T = null.asInstanceOf[T] // this is the way to intialize the variable

  def setItem(item: T): Unit ={
    this.item = item
  }

  def getItem(): T ={
    this.item
  }
}
```

Filling the basket with an `Apple`:
```Scala
  def fillBasketWithFruitString(): Unit ={
    val basket = new Basket[String]
    basket.setItem("Apple")
    println("the basket is holding: " + basket.getItem())
  }
```

## Interfaces (traits)
traits are the equivalent of interfaces. A trait can be used as an abstract layer between to talk to instead of the implementation.
this is part of the Object orientated programming paradigm, for that reason I wont dive deep into the inner workings on traits but here 
are a few examples on how to use them:
```Scala

trait Fruit {
  def eat()
}

object Apple extends Fruit {
  override def eat(): Unit = {
    println("nom nom nom")
  }
}


```
this just demonstrates a simple way on how to use a trait in scala. 

## functional programming
In the previous chapters I have covered some of the basics of the language. I have even included a functional part about higher level functions. But scala has way more functional options Under this section I aim to expolore a few of these options I came across
For this section I will use the following video https://www.youtube.com/watch?v=R0jVqeYzs9c as starting point.


### exceptions in functions
In functional programming there are no null values and no exceptions. However if you create statements there is the possibility that there might be something wrong with the input or operation.
This would require an exception to be thrown so how do we handle this in scala?

A way to solve this is by returning a value like `Some`, `Option` or `None`. These functions can be used  
```Scala
def toInt(s: String): Option[Int] = {
    try {
        Some(Integer.parseInt(s.trim))
    } catch {
        case e: Exception => None
    }
}
```
You can later match these results to get the correct output:
```Scala
toInt(x) match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
}
```
this is sort of the replacement of a null value.

### Future
Another nice thing from scala is the `Future` function. this is a way to run an concurrent operation on a different thread.
for example:
```Scala
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

object Test {

  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("lets wait for....")
    val f = Future {
      letsWait(2)
    }
    println("I'm done waiting")
    Await.result(f, 10 second)
  }

  def letsWait(seconds: Int): Unit = {
    Thread.sleep(seconds * 1000)
    println("Lets wait method is done waiting")
  }
}

```
Please note that in this example I've included the imports as well. This is because the Future function does require some special imports such as the postFixOps and duration.
These are needed for the Await function. The Await function is required for this example as the main thread will stop before the other threads are finished. in order to prevent this I have added the
await function. For production applications that run continuously it is not needed to include the await function. For those scenarios you could chain the `onComplete` to the Future. This is the equivalent 
of an promise in Javascript.
```Scala
val f = Future {
      letsWait(2)
    }
f onComplete {
      case Success(value) => {
        println("success")
      }
      case Failure(exception) => {
        println("failure")
      }
}


```
The oncomplete will have two cases the `Failure` and the `Success` case. The success will give the value returned by the Future and the Failure face will return an exception.

There is also the option to have the `Map` function on the Future. This will map all elements returned from the Future where an operation could further transform the data.

### Value classes (domain logic)
Values classes can be seen as an type or 'object'. By defining an value class you can be sure that you use the correct type for a method.
You can use it do make it easier to see what domain it is in. For example:
```Scala
case class Banana(peal: Boolean, eaten: Boolean, radioactive: Boolean)
```
This can be used to create a new object called banana or it can be used to define an type for parameters of an method.
```Scala
  def makeAndEatBanana(notUsed: Banana): Unit ={
    val banana = Banana(true, false, true)
    println(s"this banana has been eaten: ${banana.eaten}")
  }
```

## Extra
It isn't required to write down semicolons.


## An example application

For this assignment I'd need to write a program with the new knowledge I obtained from writing this 'blog',
The program will be an web crawler system with as starting point my own website: https://serverlist.games/ I'd like it to craw the entire website and crawl all links on the website
This will be done for a X amount of times with the X standing for a level. Each level is a new website that contains links.

The crawler will have the support of scanning through all results really fast via an web interface.  You can give any url to the website and you can set a maximum of websites to crawl and or an maximum level.

The crawler seems like an exiting challenge for me although it sounds easy to crawl a website by just sending a simple http request and reading the body it seems more challenging since many modern websites
are build using a javascript framework as a single page application. This means I'd first have to figure out how to load the content of an website. And then how to filter out the links of the page and crawl those.
I'd also have to know what page has already been crawled before and when the page is no longer on the same domain so I can keep track of the correct level of the crawler. Some of these seem really challenging to me and others should be a breeze.

### I've hot some difficulties

Whilst trying to figure out how to make a crawler that will support Javascript content too I hit a roadblock.
It seems you'de require an entire system (headless browser) in order to crawl that type of content. And since that will
take way too much time to setup and or build I've chosen to make the application a bit simpler that will only support websites made of plain html with all content already loaded.

My code exists of 3 parts the `Crawler`, `CrawlerMain` and the `HttpRequest`. The CrawlerMain as the name might imply is the starting point for this application. 
The Crawler itself will do a few things:
- recursively call itself with the results of the previous run
- save all results to a list and check if they already exist

The httpRequest will do the following:
- It will get the content of a website using an GET request
- It will filter out all the `<a href=""></a>` tags from the content.
- For each Anchor tag it will convert it to the pure url form `https://example.com`.
- it will map all those results to only include urls that are valid within the Anchor tags
- after that it will map all those results and transform it to the string variant
- this will be converted to an array.

These are all steps needed for a simple web crawler. This can be further expanded with saving the title of the page and use that to return a list of urls that match certain keywords
The application can also be made multi threaded in order to increase the speed of crawling.

In order to make the assignment a bit more challenging I will try to include these new options. Starting with making it multi threaded.
As I've learned at the beginning of the blog `Future`is the option to go multithreaded. 


 



## References
- https://www.geeksforgeeks.org/higher-order-functions-in-scala/
- https://alvinalexander.com/scala/scala-ternary-operator-syntax
- https://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes.html
- https://www.youtube.com/watch?v=R0jVqeYzs9c
- https://docs.scala-lang.org/tour/implicit-parameters.html
