import car.SingleAd;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import utilities.DataWriter;
import utilities.StringParser;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ScrapePrice {

    @Test
    public void main() throws IOException {
        Integer numberOfPages = 0;
        List<String> adsList = new ArrayList<>();
        //String url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page=2&sort=basic&brand=audi&model%5B0%5D=a3&year_from=2012&city_distance=0&showOldNew=all&without_price=1";
        String url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page=1&sort=basic&brand=bmw&model%5B0%5D=serija-1&year_from=2012&city_distance=0&showOldNew=all&without_price=1";
        Document page = Jsoup.connect(url).userAgent("Jsoup scraper " + new Random().nextInt(1000)).get();
        Elements numberOfPagesElements = page.select("#search-results > div:nth-child(4) > small:nth-child(1)");
        if (numberOfPagesElements.get(0) != null) {
            numberOfPages = StringParser.parseNumberOfPages(numberOfPagesElements.get(0).text());
        }
        for (int i = 1; i <= (numberOfPages / 25) + 1; i++) {
            url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page=" + i + "&sort=basic&brand=bmw&model%5B0%5D=serija-1&year_from=2012&city_distance=0&showOldNew=all&without_price=1";
            //url = "https://www.polovniautomobili.com/auto-oglasi/pretraga?page="+i+"&sort=basic&brand=audi&model%5B0%5D=a3&year_from=2013&city_distance=0&showOldNew=all&without_price=1";
            page = Jsoup.connect(url).userAgent("Jsoup scraper " + new Random().nextInt(1000)).get();
            Elements carCompleteInfo = page.select("article[class^=single-classified ad]");
            for (Element element : carCompleteInfo
            ) {
                SingleAd adDetails = StringParser.parseAd(element.text());
                if (!adsList.contains(adDetails.toString())) {
                    if (adDetails.getPrice() != 0) {
                        adsList.add(adDetails.toString());
                        System.out.println(adDetails.toString());
                    }
                }
            }
        }
        DataWriter.writeToFile(adsList);
    }

}
