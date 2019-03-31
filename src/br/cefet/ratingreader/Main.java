package br.cefet.ratingreader;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.search.Search;

public class Main {
    public static void main(String[] args) {
        CSVReader.openCSV("/home/francisco/Downloads/ListaObraDadosAbertos.csv");
//        while (true) {
//            String[] data = CSVReader.readCSV();
//            for(int i = 0; i < data.length; i++) {
//                System.out.println("[" + i + "]: " + data[i]);
//            }
//            System.out.println();
//            System.out.println();
//        }


        String data[] = Search.searchByName("TROPA DE ELITE 2");
        if (data != null) {
            for (String s:
                 data) {
                System.out.println(s);
            }
        } else {
            System.out.println(data);
        }
    }
}
