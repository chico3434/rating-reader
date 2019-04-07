package br.cefet.ratingreader.utils;

public class Rating {

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
