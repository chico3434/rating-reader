package br.cefet.ratingreader.reader;

public class CSVReader {

    public static boolean openCSV(String path) {
        return Reader.openFile(path);
    }

    public static String[] readCSV() {
        String line = Reader.readLine();
        if (line != null) {
            return line.split(";");
        } else {
            closeCSV();
            return null;
        }
    }

    public static String[] readCSV(int... index) {
        String line = Reader.readLine();
        if (line != null) {
            String[] values = line.split(";");
            String[] returnedValues = new String[index.length];
            int cont  = 0;
            for (int i : index) {
                returnedValues[cont] = values[i];
                cont++;
            }
            return returnedValues;
        } else {
            closeCSV();
            return null;
        }
    }

    public static boolean closeCSV() {
        return Reader.closeFile();
    }
}
