package utilities;

import car.SingleAd;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StringParser {

    public static SingleAd parseAd(String text) {
        Integer price;
        Integer mileage;
        Integer year;
        SingleAd.FuelType fuelType;
        Integer cubicCentimeters;
        Integer horsePower;
        SingleAd.Gearbox gearbox;

        List<Integer> indices = IntStream
                .iterate(text.indexOf('|'), index -> index >= 0, index -> text.indexOf('|', index + 1))
                .boxed()
                .collect(Collectors.toList());
        String priceContainer = text.substring(0, indices.get(0));
        String mileageContainer = text.substring(indices.get(0) + 1, indices.get(1));
        String fuelTypeContainer = text.substring(indices.get(1) + 1, indices.get(2));
        String carDetailsContainer = text.substring(indices.get(2) + 1, text.length());

        price = parsePrice(priceContainer);
        mileage = parseMileage(mileageContainer);
        year = parseYear(priceContainer);
        fuelType = SingleAd.FuelType.get(fuelTypeContainer.trim());
        cubicCentimeters = parseCubicCapacity(carDetailsContainer);
        horsePower = parseHorsePower(carDetailsContainer);
        gearbox = parseGearbox(carDetailsContainer);

        SingleAd currentAd = new SingleAd();
        currentAd.setPrice(price);
        currentAd.setMileage(mileage);
        currentAd.setYear(year);
        currentAd.setFuelType(fuelType);
        currentAd.setCubicCapacity(cubicCentimeters);
        currentAd.setHorsepower(horsePower);
        currentAd.setGearbox(gearbox);

        return currentAd;

    }

    public static Integer parsePrice(String priceContainer) {
        String price;
        Integer priceValue = 0;
        Pattern patternPrice = Pattern.compile("\\s\\d*[.]\\d*\\s[€]");
        Matcher matcherPrice = patternPrice.matcher(priceContainer);
        if (matcherPrice.find()) {
            price = matcherPrice.group(0);
            priceValue = Integer.parseInt(price.substring(0, price.length() - 2).replace(".", "").trim());
            return priceValue;
        } else return 0;

    }

    public static Integer parseMileage(String mileageContainer) {
        String mileage;
        Integer mileageValue = 0;
        Pattern patternPrice = Pattern.compile("\\d*[.]\\d*");
        Matcher matcherPrice = patternPrice.matcher(mileageContainer);
        if (matcherPrice.find()) {
            mileage = matcherPrice.group(0);
            mileageValue = Integer.parseInt(mileage.replace(".", "").trim());
            return mileageValue;
        } else {
            return 0;
        }

    }

    public static Integer parseYear(String priceContainer) {
        return Integer.parseInt(priceContainer.substring(priceContainer.length() - 6, priceContainer.length() - 2));
    }

    public static Integer parseCubicCapacity(String carDetailsContainer) {
        String cc;
        Integer ccValue = 0;
        Pattern patternPrice = Pattern.compile("\\d*\\s[c][m][3]");
        Matcher matcherPrice = patternPrice.matcher(carDetailsContainer);
        if (matcherPrice.find()) {
            cc = matcherPrice.group(0);
            ccValue = Integer.parseInt(cc.substring(0, cc.length() - 4).trim());
            return ccValue;
        } else {
            return 0;
        }

    }

    public static Integer parseHorsePower(String carDetailsContainer) {
        String hp;
        Integer hpValue = 0;
        Pattern patternHp = Pattern.compile("[(][\\d]*[K][S][)]");
        Matcher matcherHp = patternHp.matcher(carDetailsContainer);
        if (matcherHp.find()) {
            hp = matcherHp.group(0);
            hpValue = Integer.parseInt(hp.substring(1, hp.length() - 3).trim());
            return hpValue;
        } else {
            return 0;
        }
    }

    public static SingleAd.Gearbox parseGearbox(String carDetailsContainer) {
        String gearbox;
        SingleAd.Gearbox gearboxValue;
        Pattern patternHp = Pattern.compile("[K][S][)][,]\\s\\S*");
        Matcher matcherHp = patternHp.matcher(carDetailsContainer);
        if (matcherHp.find()) {
            gearbox = matcherHp.group(0);
            gearboxValue = SingleAd.Gearbox.get(gearbox.substring(5, gearbox.length()).trim());
            return gearboxValue;
        } else {
            return SingleAd.Gearbox.MANUAL;
        }
    }

    public static Integer parseNumberOfPages(String pageNumberContainer) {
        String numberOfPages;
        Integer numberOfPagesValue;
        Pattern patternPages = Pattern.compile("[u][k][u][p][n][o]\\s\\d*");
        Matcher matcherPages = patternPages.matcher(pageNumberContainer);
        if (matcherPages.find()) {
            numberOfPages = matcherPages.group(0);
            numberOfPagesValue = Integer.valueOf(numberOfPages.trim().substring(7));
            return numberOfPagesValue;
        } else {
            return 0;
        }
    }


}
