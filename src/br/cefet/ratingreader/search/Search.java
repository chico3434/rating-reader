package br.cefet.ratingreader.search;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.utils.Movies;
import br.cefet.ratingreader.utils.Rating;
import br.cefet.ratingreader.utils.Values;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Search {
    public static Set<String[]> searchAndReturnSet(String path) {
        List<String> movies = (Values.readFile)? Movies.getMoviesToBeSearched(new File(path + "/movies.txt")) : Movies.getMoviesToBeSearched(path);
        Set<String[]> setOfResults = new HashSet<>();
        System.out.println("Buscando...");
        while(CSVReader.hasNext()) {
            String[] data = CSVReader.readCSV();
            if (data.length > Values.indexOfType) {
                if (data[Values.indexOfType].trim().equals("Longa Metragem")) {
                    if (movies.contains(data[Values.indexOfName].trim().toLowerCase())) {
                        if (Values.standardOutput) {
                            String[] formattedResult = new String[2];
                            formattedResult[0] = data[Values.indexOfName];
                            formattedResult[1] = Rating.preparedRating(data[Values.indexOfRating]);
                            setOfResults.add(formattedResult);
                        }else {
                            setOfResults.add(data);
                        }
                        movies.remove(movies.get(movies.indexOf(data[Values.indexOfName].trim().toLowerCase())));
                    }
                }
            }
        }
        System.out.println("Busca terminada");
        return setOfResults;
    }

}
