package me.unisteven.crawler

object CrawlerMain {

  val startingURL: String = "https://nl.wikipedia.org/wiki/See_the_sky_about_to_rain";
  val crawler = new Crawler
  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    val urls = crawler.crawlRecursively(Website(startingURL, "begin"), 0)
    val endTime = System.currentTimeMillis();
    println(s"duplicates: {${crawler.duplicates}}")
    println(s"It took a total of ${(endTime - startTime)} ms to complete the crawl")
//    urls.foreach(println(_))
  }

}
