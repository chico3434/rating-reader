package br.cefet.ratingreader;

import br.cefet.ratingreader.reader.CSVReader;

public class Main {
    public static void main(String[] args) {
        CSVReader.openCSV("/home/francisco/Downloads/ListaObraDadosAbertos.csv");
        while (true) {
            String[] data = CSVReader.readCSV(1, 16);
            if (data != null) {
                System.out.println("Nome: " + data[0] + " Classificação: " + data[1]);
            }
        }
    }
}
