package me.unisteven.crawler

import java.net.ConnectException


class HttpRequest {

  def get(url: String): String = {
    println(url)
    try {
      scala.io.Source.fromURL(url).mkString
    } catch {
      case x: Exception => {
        ""
      }
    }
  }

  def allLinks(content: String): Array[Website] = {
    val hrefPattern = "<(a+) (?!(?:href=([\"|']+)([http:\\/\\/])*link\\.com([\\/])?(.*?)[\"|'])) *[^>]*>(.*?)[^>]>".r
    hrefPattern.findAllIn(content).map(getPureUrl).filter(x => x.isDefined).map(_.get).toArray
  }

  def getPureUrl(href: String): Option[Website] = {
    val urlPattern = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".r
    val titlePattern = "title=\"(.*?)\"".r
    var urlFound = urlPattern.findFirstIn(href)
    var url = ""
    if (urlFound.isDefined) {
      url = urlFound.get
    }
    var titleFound = titlePattern.findFirstIn(href)
    var title = ""
    if (titleFound.isDefined) {
      title = titleFound.get.replace("title=", "").replaceAll("\"", "")
    }
    if (titleFound.isEmpty || urlFound.isEmpty) {
      None
    } else {
      Some(Website(url, title))
    }

  }


  def getAllUrlsFromUrl(url: String): Array[Website] = allLinks(get(url))

}
