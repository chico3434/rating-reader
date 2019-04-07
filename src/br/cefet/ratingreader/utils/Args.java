package br.cefet.ratingreader.utils;

public class Args {
    public static void readArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-")) {
                if (args[i].contains("D")) {
                    Values.setDefault();
                }
                if (args[i].contains("f")) {
                    Values.readFile = true;
                }
                if (args[i].contains("d")) {
                    Values.readFile = false;
                }
                if (args[i].contains("s")) {
                    Values.save = true;
                }
                if (args[i].contains("c")) {
                    Values.console = true;
                }
            }
            if (args[i].contains("source=")) {
                Values.source = args[i].replace("source=", "");
            }
            if (args[i].contains("out=")) {
                Values.out = args[i].replace("out=", "");
            }
        }
    }

}
