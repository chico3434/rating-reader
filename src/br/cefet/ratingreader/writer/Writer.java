package br.cefet.ratingreader.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Writer {

    public static boolean write(String path, Set<String[]> result) {
        System.out.println("Salvando...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            Iterator<String[]> iterator = result.iterator();
            while(iterator.hasNext()) {
                String[] movie = iterator.next();
                bufferedWriter.append(movie[0] + "," + movie[1]+ "\n");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
