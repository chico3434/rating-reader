package br.cefet.ratingreader.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FormattedWriter {

    public static boolean write(String path, List<String[]> result) {
        System.out.println("Salvando...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (String[] movie : result) {
                String name = movie[2].toLowerCase();
                String rating = preparedRating(movie[16]);

                bufferedWriter.append(name + "," + rating+ "\n");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writeSet(String path, List<String[]> result) {
        Set<String[]> set = new HashSet<>();
        set.addAll(result);
        System.out.println("Salvando...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            Iterator<String[]> iterator = set.iterator();
            while(iterator.hasNext()) {
                String[] movie = iterator.next();
                String name = movie[2];
                String rating = preparedRating(movie[16]);

                bufferedWriter.append(name + "," + rating+ "\n");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String preparedRating (String oldRating) {
        if (oldRating.contains("livre")) {
            return "0";
        }
        if (oldRating.contains("10") || oldRating.contains("dez")) {
            return "10";
        }
        if (oldRating.contains("12") || oldRating.contains("doze")) {
            return "12";
        }
        if (oldRating.contains("14") || oldRating.contains("quatorze") || oldRating.contains("catorze")) {
            return "14";
        }
        if (oldRating.contains("16") || oldRating.contains("dezesseis")) {
            return "16";
        }
        if (oldRating.contains("18") || oldRating.contains("dezoito")) {
            return "18";
        }
        return "Inválido";
    }
}
