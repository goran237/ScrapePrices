import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Test;
import utilities.Parser;

import java.io.IOException;
import java.util.List;

public class ScrapePrice {

    @Test
    public void main() throws IOException {
        String url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page=1&sort=basic&brand=bmw&model%5B0%5D=serija-1&year_from=2012&city_distance=0&showOldNew=all&without_price=1";
        Document page = Jsoup.connect(url).userAgent("Jsoup scraper").get();
        Elements carDetails = page.select("article[class^=single-classified ad] > div");
        Elements carBasics = page.select("article[class^=single-classified ad]>h2");
        Elements carCompleteInfo= page.select("article[class^=single-classified ad]");
        for (Element element : carCompleteInfo
        ) {
            String mileage;
            System.out.println(element.text());
            Parser.parseAd("text");

        }
    }

}
