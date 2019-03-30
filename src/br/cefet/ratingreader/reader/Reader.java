package br.cefet.ratingreader.reader;

import java.io.*;

public class Reader {

    private static BufferedReader bufferedReader;
    private static java.io.Reader reader;

    public static boolean openFile(String path) {
        File file = new File(path);
        try {
            reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            bufferedReader = new BufferedReader(reader);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String readLine() {
        try {
            String line = bufferedReader.readLine();
            return line;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean closeFile() {
        try {
            reader.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
