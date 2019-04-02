package br.cefet.ratingreader.search;

import br.cefet.ratingreader.reader.CSVReader;

public class Search {

    public static String[] searchByName(String name) {
        String[] data = CSVReader.readCSV();
        while(data != null) {
            if (data.length > 10) {
                if (data[10].trim().equals("Longa Metragem")) {
                    if (data[2].trim().toLowerCase().equals(name.toLowerCase())) {
                        return data;
                    }
                }
            }
            data = CSVReader.readCSV();
        }
        return null;
    }

}
