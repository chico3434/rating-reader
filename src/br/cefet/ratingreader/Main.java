package br.cefet.ratingreader;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.search.Search;

public class Main {
    public static void main(String[] args) {
        String path = "";
        String movieSearch = "";
        String pathSearch = "";
        String out = "";
        for(int i = 0; i < args.length; i++) {
            if (args[i].contains("--path=")) {
                path = args[i].replace("--path=", "");
            }
            if (args[i].contains("--search-movie=")) {
                movieSearch = args[i].replace("--search-movie=", "").replace("_", "");
            }
            if (args[i].contains("--search-path=")) {
                pathSearch = args[i].replace("--search-path=", "");
            }
            if (args[i].contains("--out=")) {
                out= args[i].replace("--out=", "");
            }
        }

        CSVReader.openCSV(path);

        if (!pathSearch.equals("")) {

        }

        if (!movieSearch.equals("")) {
            String data[] = Search.searchByName(movieSearch);
            if (data != null) {
                for (String s : data) {
                    System.out.println(s);
                }
            } else {
                System.out.println(data);
            }
        }
    }
}
