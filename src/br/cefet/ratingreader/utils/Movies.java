package br.cefet.ratingreader.utils;

import br.cefet.ratingreader.reader.Reader;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Movies {

    public static List<String> getMoviesToBeSearched(String path) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".txt");
            }
        };

        List<String> movieNames = new ArrayList<>();

        File dir = new File(path);

        File[] files = dir.listFiles(filter);

        for (File file : files) {
            movieNames.add(file.getName().replace(".txt", ""));
        }
        System.out.println("Tam" + movieNames.size());
        return movieNames;
    }

    public static List<String> getMoviesToBeSearched(File file) {
        List<String> movies = new ArrayList<>();
        Reader reader = new Reader(file);
        System.out.println("Lendo filmes");
        while (reader.hasNext()) {
            System.out.print(".");
            movies.add(reader.readLine().trim().toLowerCase());
        }
        System.out.println("Leitura terminada");
        return movies;
    }

}
