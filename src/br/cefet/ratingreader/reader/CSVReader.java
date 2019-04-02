package br.cefet.ratingreader.reader;

public class CSVReader {

    public static Reader reader;

    public static boolean hasNext() {
        return reader.hasNext();
    }

    public static boolean openCSV(String path) {
        reader = new Reader();
        return reader.openFile(path);
    }

    public static String[] readCSV() {
        String line = reader.readLine();
        if (line != null) {
            return line.split(";");
        } else {
            closeCSV();
            return null;
        }
    }

    public static String[] readCSV(int... index) {
        String line = reader.readLine();
        if (line != null) {
            String[] values = line.split(";");
            // Caso ele não consiga retornar os campos indicados (Pro problema no CSV)
            if (values.length <= index[index.length - 1]) {
                return null;
            }

            String[] returnedValues = new String[index.length];
            int cont  = 0;
            for (int i : index) {
                returnedValues[cont] = values[i];
                cont++;
            }
            return returnedValues;
        } else {
            return null;
        }
    }

    public static boolean closeCSV() {
        return reader.closeFile();
    }
}
