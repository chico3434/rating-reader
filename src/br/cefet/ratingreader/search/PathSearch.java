package br.cefet.ratingreader.search;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class PathSearch {

    public static List<String[]> searchByPath(String path) {
        List<String> movies = getMovieToBeSearch(path);
        List<String[]> listOfResults = new ArrayList<>();
        System.out.println("Buscando...");
        while (CSVReader.hasNext()) {
            String[] data = CSVReader.readCSV();
            System.out.print(".");
            if (movies.contains(data[2].trim().toLowerCase())) {
                if (data[10].trim().equals("Longa Metragem")) {
                    System.out.println("\nAchado: " + data[2]);
                    listOfResults.add(data);
                }
            }

        }
        System.out.println("Busca terminada");
        return listOfResults;
    }

    public static List<String> getMovieToBeSearch(String path) {
        List<String> movies = new ArrayList<>();
        Reader reader = new Reader(path);
        System.out.println("Lendo filmes");
        while (reader.hasNext()) {
            System.out.print(".");
            movies.add(reader.readLine().trim().toLowerCase());
        }
        System.out.println("Leitura terminada");
        return movies;
    }

}
