package me.unisteven.crawler

object CrawlerMain {

  val startingURL: String = "https://stackoverflow.com/";
  val crawler = new Crawler
  val keywords = Array("apps", "scala", "kotlin")
  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    val urls = crawler.crawlRecursively(Website(startingURL, "begin"), 0)
    val endTime = System.currentTimeMillis();
    println(s"duplicates: {${crawler.duplicates}}")
    println(s"It took a total of ${(endTime - startTime)} ms to complete the crawl")
    println("The following url's match the search keywords")
    val matched = crawler.matchKeyWords(keywords, urls)
    matched.foreach(println(_));
  }

}
