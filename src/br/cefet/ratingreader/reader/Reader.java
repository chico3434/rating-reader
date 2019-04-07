package br.cefet.ratingreader.reader;

import java.io.*;

public class Reader {

    private FileInputStream fileInputStream;

    public Reader() {}

    public Reader(String path) {
        openFile(path);
    }

    public Reader(File file) {
        openFile(file);
    }

    public boolean hasNext() {
        try {
            return  (fileInputStream.available() > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean openFile(String path) {
        try {
            fileInputStream = new FileInputStream(path);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean openFile(File file) {
        try {
            fileInputStream = new FileInputStream(file);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String readLine() {
        try {
            int avalaible = fileInputStream.available();
            String line = "";
            for (int i = 0; i < avalaible; i++) {
                /*
                * O if é a lógica que faz parar de ler quando a linha termina
                * o \n indica a quebra de linha
                * quando a String line tiver \n significa que esta linha chegou ao fim
                * o replace serve para tirar o \n dos dados
                * */
                if (line.contains("\n")) {
                    line = line.replace("\n", "");
                    break;
                }
                char character = (char) fileInputStream.read();
                line += character;
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean closeFile() {
        try {
            fileInputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
