package br.cefet.ratingreader.utils;

import java.util.Iterator;
import java.util.Set;

public class Console {

    public static void write(Set<String[]> result) {
        Iterator<String[]> iterator = result.iterator();
        while(iterator.hasNext()) {
            String[] movie = iterator.next();
            System.out.println(movie[0] + "," + movie[1]+ "\n");
        }
    }
}
