package br.cefet.ratingreader;

import br.cefet.ratingreader.reader.CSVReader;
import br.cefet.ratingreader.search.PathSearch;
import br.cefet.ratingreader.search.Search;
import br.cefet.ratingreader.writer.Writer;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String path = "";
        String movieSearch = "";
        String pathSearch = "";
        String out = "";
        List<String[]> result = null;
        String[] uniqueResult = new String[0];
        for(int i = 0; i < args.length; i++) {
            if (args[i].contains("--path=")) {
                path = args[i].replace("--path=", "");
            }
            if (args[i].contains("--search-movie=")) {
                movieSearch = args[i].replace("--search-movie=", "").replace("_", "");
            }
            if (args[i].contains("--search-path=")) {
                pathSearch = args[i].replace("--search-path=", "");
            }
            if (args[i].contains("--out=")) {
                out = args[i].replace("--out=", "");
            }
        }

        if (!path.equals("")) {
            CSVReader.openCSV(path);
        } else {
            System.out.println("Entre com o caminho: ");
            path = sc.nextLine();
            CSVReader.openCSV(path);
        }

        if (pathSearch.equals("")) {
            System.out.println("Entre com o caminho do arquivo: ");
            System.out.println("Caso queira ler um só filme digite \'skip\'");
            pathSearch = sc.nextLine();
            if (!pathSearch.trim().toLowerCase().equals("skip")) {
                result = PathSearch.searchByPath(pathSearch);
                if (result != null) {
                    for (String[] movie : result) {
                        System.out.printf("Nome: %s - Classificação %s\n", movie[1], movie[16]);
                    }
                } else {
                    System.out.println("Algum erro ocorreu");
                }
            } else {
                pathSearch = "";
            }
        } else {
                result = PathSearch.searchByPath(pathSearch);
                if (result != null) {
                    for (String[] movie : result) {
                        System.out.printf("Nome: %s - Classificação %s\n", movie[1], movie[16]);
                    }
                } else {
                    System.out.println("Algum erro ocorreu");
                }
        }

        if (movieSearch.equals("")) {
            if (pathSearch.equals("")) {
                System.out.println("Entre com o filme a ser buscado: ");
                movieSearch = sc.nextLine();
                uniqueResult = Search.searchByName(movieSearch);
                if (uniqueResult != null) {
                    for (String string : uniqueResult) {
                        System.out.println(string);
                    }
                } else {
                    System.out.println(uniqueResult);
                }
            }

        } else {
            System.out.println(movieSearch);
            String data[] = Search.searchByName(movieSearch);
            if (data != null) {
                for (String s : data) {
                    System.out.println(s);
                }
            } else {
                System.out.println(data);
            }
        }

        if (out.equals("")) {
            System.out.println("Deseja salvar?");
            String response = sc.nextLine();
            if (response.equals("sim")) {
                System.out.println("Onde deseja salvar?");
                out = sc.nextLine();

            } else {
                System.exit(0);
            }
        }
        if (result != null) {
            if (Writer.write(out, result)) {
                System.out.println("Salvo com sucesso!");
            } else {
                System.out.println("Erro ao salvar!");
            }
        } else {
            if (uniqueResult.length > 0) {
                if (Writer.write(out, uniqueResult)) {
                    System.out.println("Salvo com sucesso!");
                } else {
                    System.out.println("Erro ao salvar!");
                }
            }
        }
    }
}
