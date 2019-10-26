package me.unisteven.crawler

object CrawlerMain {

  val startingURL: String = "https://stackoverflow.com/";
  val crawler = new Crawler
  def main(args: Array[String]): Unit = {
    val urls = crawler.crawlRecursively(startingURL, 0)
    urls.foreach(println(_))
  }
}
