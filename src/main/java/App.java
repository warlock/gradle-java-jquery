import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {

  public static void main(String[] args) {
    Document doc;
    try {
      doc = Jsoup.connect("http://en.wikipedia.org/").get();
      System.out.println(doc.title());
      Elements newsHeadlines = doc.select("#mp-itn b a");
      
      for (Element headline : newsHeadlines) {
      System.out.printf("%s\n\t%s", 
      headline.attr("title"), headline.absUrl("href"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
