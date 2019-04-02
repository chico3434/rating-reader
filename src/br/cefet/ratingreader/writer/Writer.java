package br.cefet.ratingreader.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public static boolean write(String path, List<String[]> result) {
        System.out.println("Salvando...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (String[] movie : result) {
                bufferedWriter.append(movie[1] + " @ " + movie[16] + "\n");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean write(String path, String[] result) {
        System.out.println("Salvando...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(result[1] + " @ " + result[16] + "\n");
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
