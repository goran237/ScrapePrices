package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DataWriter {

    public static void writeToFile(List<String> listOfAds) throws IOException {
        String fileName = "Series_1_price_" + LocalDate.now() + ".csv";
        FileWriter csvWriter = new FileWriter(fileName);
        csvWriter.append("Price");
        csvWriter.append(",");
        csvWriter.append("Year");
        csvWriter.append(",");
        csvWriter.append("Mileage");
        csvWriter.append(",");
        csvWriter.append("Fuel Type");
        csvWriter.append(",");
        csvWriter.append("Displacement");
        csvWriter.append(",");
        csvWriter.append("Horsepower");
        csvWriter.append(",");
        csvWriter.append("Gearbox");
        csvWriter.append("\n");

        for (String rowData : listOfAds) {
            csvWriter.append(rowData);
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
