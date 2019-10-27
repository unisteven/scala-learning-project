package me.unisteven.crawler

import scala.collection.mutable.ListBuffer

class Crawler {

  val MAXLEVEL: Int = 3;
  var duplicates = 1
  val http: HttpRequest = new HttpRequest
  var urls: ListBuffer[Website] = new ListBuffer[Website]

  def crawlRecursively(website: Website, level: Int): List[Website] = {
    if (level >= MAXLEVEL) {
      return urls.toList // end condition
    }
    http.getAllUrlsFromUrl(website.url).foreach(saveUrlsToListAndCallRecursive(_, level))
    urls.toList
  }

  def saveUrlsToListAndCallRecursive(content: Website, level: Int): Unit = {
    if (urls.exists(_.url.equals(content.url))) {
      duplicates = duplicates + 1
      return // return in case the url already exists so it wont crawl it twice.
    }
    println(s"found($level): (${content.url}, ${content.title})")
    urls += content
    crawlRecursively(content, level + 1)
  }
}
