package me.unisteven.crawler

object CrawlerMain {

  val startingURL: String = "https://stackoverflow.com/";
  val crawler = new Crawler
  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    val urls = crawler.crawlRecursively(startingURL, 0)
    val endTime = System.currentTimeMillis();
    println(s"It took a total of ${(endTime - startTime)} ms to complete the crawl")
//    urls.foreach(println(_))
  }
}
