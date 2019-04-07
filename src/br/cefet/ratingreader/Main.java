package br.cefet.ratingreader;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.search.Search;
import br.cefet.ratingreader.utils.Args;
import br.cefet.ratingreader.utils.Console;
import br.cefet.ratingreader.utils.Values;
import br.cefet.ratingreader.writer.Writer;

import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Args.readArgs(args);
        if (Values.source != null) {
            CSVReader.openCSV(Values.source);
        } else {
            System.out.println("Entre com o caminho: ");
            Values.source = sc.nextLine();
            CSVReader.openCSV(Values.source);
        }
        if (Values.out == null) {
            System.out.println("Entre com o caminho de saída: ");
            Values.out = sc.nextLine();
        }

        Set<String[]> resultSet = Search.searchAndReturnSet(Values.out);
        if (Values.save) {
            if (Writer.write(Values.out + "/rating.csv", resultSet)) {
                System.out.println("Salvo com sucesso!");
            } else {
                System.out.println("Erro ao salvar!");
            }
        }
        if (Values.console) {
            Console.write(resultSet);
        }
    }
}
