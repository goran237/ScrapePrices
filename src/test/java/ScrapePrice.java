import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ScrapePrice {

    @Test
    public void main() throws IOException {
        String url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page=1&sort=basic&brand=bmw&model%5B0%5D=serija-1&year_from=2012&city_distance=0&showOldNew=all&without_price=1";
        Document page = Jsoup.connect(url).userAgent("Jsoup scraper").get();
        Elements elements = page.select("article");
        for (Element element : elements
        ) {
            String mileage;
            Elements elements_level_2 = element.select("div>div:nth-child(2)>div:nth-child(1)");
            if (elements_level_2.size() > 2) {
                mileage = elements_level_2.get(1).child(0).child(0).child(0).child(1).text();
                System.out.println(mileage);
            }
        }

    }

}
