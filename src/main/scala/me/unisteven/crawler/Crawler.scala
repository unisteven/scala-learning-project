package me.unisteven.crawler

import scala.collection.mutable.ListBuffer
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.language.postfixOps
import scala.concurrent.duration._
import scala.util.{Failure, Success}

class Crawler {

  val MAXLEVEL: Int = 4;
  val http: HttpRequest = new HttpRequest
  var urls: ListBuffer[String] = new ListBuffer[String]
  implicit val ec: ExecutionContext = ExecutionContext.global

  def crawlRecursively(url: String, level: Int): List[String] ={
    if(level >= MAXLEVEL){
      return urls.toList // end condition
    }
    val f = Future {
      http.getAllUrlsFromUrl(url).foreach(saveUrlsToListAndCallRecursive(_, level))
    }
    Await.result(f, 10 days)
//    http.getAllUrlsFromUrl(url).foreach(saveUrlsToListAndCallRecursive(_, level))
    urls.toList
  }

  def saveUrlsToListAndCallRecursive(content: String, level: Int): Unit ={
    if(urls.contains(content)){
      return // return in case the url already exists so it wont crawl it twice.
    }
    println(s"found($level): $content")
    urls += content
    crawlRecursively(content, level + 1);
  }
}
