package me.unisteven.crawler

import scala.collection.mutable.ListBuffer

class Crawler {

  val MAXLEVEL: Int = 2;
  val http: HttpRequest = new HttpRequest
  var urls: ListBuffer[String] = new ListBuffer[String]
  def crawlRecursively(url: String, level: Int): List[String] ={
    if(level >= MAXLEVEL){
      return urls.toList // end condition
    }
    http.getAllUrlsFromUrl(url).foreach(saveUrlsToListAndCallRecursive(_, level));
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
