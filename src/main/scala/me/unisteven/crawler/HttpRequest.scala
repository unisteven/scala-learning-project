package me.unisteven.crawler

import java.net.ConnectException



class HttpRequest {

  def get(url: String): String = {
    try {
      scala.io.Source.fromURL(url).mkString
    } catch {
      case x: ConnectException => {
        "" // return an empty string for that website if they are not available
      }
    }
  }

  def allLinks(content: String): Array[String] = {
    val hrefPattern = "<(a+) (?!(?:href=([\"|']+)([http:\\/\\/])*link\\.com([\\/])?(.*?)[\"|'])) *[^>]*>(.*?)[^>]>".r
    hrefPattern.findAllIn(content).map(getPureUrl).filter(x => x.isDefined).map(_.get).toArray
  }

  def getPureUrl(href: String): Option[String] ={
        val urlPattern = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".r
        urlPattern.findFirstIn(href)
  }

  def getAllUrlsFromUrl(url: String): Array[String] = allLinks(get(url))

}
