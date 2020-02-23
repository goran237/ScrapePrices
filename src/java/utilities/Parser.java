package utilities;

import car.SingleAd;

import java.util.List;
import java.util.stream.*;

public class Parser {

    public static void parseAd(String text){
        final String example = "BMW 116 116D FUL.LED AUT. (može zamena) 13.999 € + registracija 17 HD 17 HD 2016. | 143.963 km | Dizel | 1496 cm3, Hečbek, 85kW (116KS), Automatski menjač, Automatska klima, 4/5 vrata, 5 sedišta, Francuska, Kragujevac Garancija Lizing Kredit Oštećenje Na ime kupca";
        List<Integer> indices = IntStream
                .iterate(example.indexOf('|'), index -> index >= 0, index -> example.indexOf('|', index + 1))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(indices);
    }
}
