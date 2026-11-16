/*
 * Provides word lists for testing.
 * getSmallWords() is useful for debugging.
 * getMediumWords() tests basic functionality.
 * getLargeWords() tests optimization (5,000 words).
 * getHugeWords() is a stress test (10,000 words).
 * getLongWords() has fewer words but with very long lengths (~1000 chars).
 */

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public final class Words {
    // Resolved relative to the working directory, so run from the project root.
    private static final Path DATA_DIR = Paths.get("data");

    private Words() {}

    private static List<String> loadWords(String filename) {
        Path filepath = DATA_DIR.resolve(filename);
        try {
            return Files.readAllLines(filepath).stream()
                    .map(String::strip)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(
                    "Could not read " + filepath.toAbsolutePath()
                            + " (run from the project root)", e);
        }
    }

    public static List<String> getSmallWords() {
        return loadWords("words_small.txt");
    }

    public static List<String> getMediumWords() {
        return loadWords("words_medium.txt");
    }

    public static List<String> getLargeWords() {
        return loadWords("words_large.txt");
    }

    public static List<String> getHugeWords() {
        return loadWords("words_huge.txt");
    }

    public static List<String> getLongWords() {
        return loadWords("words_long.txt");
    }

    public static List<String> getExampleWords() {
        return List.of("apple", "app", "banana", "nana", "application", "cat", "dog");
    }
}
