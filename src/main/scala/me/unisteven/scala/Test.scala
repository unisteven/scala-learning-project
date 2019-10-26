package me.unisteven.scala

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.{Failure, Success}

case class Banana(peal: Boolean, eaten: Boolean, radioactive: Boolean)

object Test {


  implicit val ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    println("lets wait for....")
    val f = Future[Int] {
      letsWait(2)
    }
//    f foreach  (item => item + 1)
    f onComplete {
      case Success(value) => {
        println("success" + value)
      }
      case Failure(exception) => {
        println("failure")
      }
    }

    println("I'm done waiting")
    Await.result(f, 10 second)
//    makeAndEatBanana()

  }

  def makeAndEatBanana(notUsed: Banana): Unit ={
    val banana = Banana(true, false, true)
    println(s"this banana has been eaten: ${banana.eaten}")
  }

  def letsWait(seconds: Int): Int = {
    Thread.sleep(seconds * 1000)
    println("Lets wait method is done waiting")
//    val arr = Array[Int]()
//    arr :+ 1
//    arr :+ 2
//    arr :+ 3
//    arr// lets return an array of 3 elements
    1
  }
}
