package br.cefet.ratingreader.search;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class PathSearch {

    public static List<String[]> searchByPath(String path) {
        Reader reader = new Reader(path);
        List<String[]> listOfResults = new ArrayList<>();
        while (CSVReader.hasNext()) {
            String[] data = CSVReader.readCSV();
            while(reader.hasNext()) {
                String title = reader.readLine().trim().toLowerCase();
                if (data[1].trim().toLowerCase().equals(title)) {
                    listOfResults.add(data);
                }
            }
        }
        return listOfResults;
    }

}
