/*
 * Runs your Solver. It's useful to see how Solver is called.
 * You may want to change how Solver is constructed.
 */

import java.util.List;

public class Main {

    static void banner(String legend) {
        String border = "#".repeat(legend.length() + 8);
        System.out.println(border);
        System.out.println("#   " + legend + "   #");
        System.out.println(border);
    }

    public static void main(String[] args) {
        banner("BEGIN CODE OUTPUT");

        List<String> words = Words.getExampleWords();
        WordList wl = new WordList(words);

        System.out.println("  Input words: " + words);
        System.out.println("  Valid words: " + wl.getWords());
        System.out.println();

        Solver solver = new Solver(wl);
        List<String> containers = solver.findContainers();

        System.out.println("  Container words: " + containers);
        System.out.println();

        if (containers != null && !containers.isEmpty()) {
            System.out.println("  Details:");
            for (String container : containers) {
                // Find what it contains
                for (String word : wl.getWords()) {
                    if (!word.equals(container) && wl.containsAsSubstring(container, word)) {
                        System.out.println("    '" + container + "' contains '" + word + "'");
                    }
                }
            }
        }

        banner("END CODE OUTPUT");
    }
}
