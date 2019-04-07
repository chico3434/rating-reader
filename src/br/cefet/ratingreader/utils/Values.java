package br.cefet.ratingreader.utils;

public class Values {

    public static boolean console = false;
    public static boolean save = false;
    public static boolean readFile = false;
    // Ainda não foi implementado corretamente caso essa opção seja falsa
    public static boolean standardOutput = true;
    public static String source;
    public static String out;
    // Ainda pode ser implementada a possibilidade de mudança dos valores abaixo (Caso seja uma fonte diferente)
    public static int indexOfName = 2;
    public static int indexOfType = 10;
    public static int indexOfRating = 16;

    public static void setDefault() {
        console = true;
        save = true;
        readFile = true;
        standardOutput = true;
    }

}
