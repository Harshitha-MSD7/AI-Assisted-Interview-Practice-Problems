import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolverTest {

    private static List<String> sorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    private static double secondsSince(long startNanos) {
        return (System.nanoTime() - startNanos) / 1_000_000_000.0;
    }

    @Test
    void testSolverReturnsList() {
        WordList wl = new WordList(List.of("cat", "dog"));
        Solver solver = new Solver(wl);
        List<String> result = solver.findContainers();
        assertInstanceOf(List.class, result);
    }

    @Test
    @DisplayName("apple contains app, banana contains nana.")
    void testSimpleContainers() {
        WordList wl = new WordList(List.of("apple", "app", "banana", "nana"));
        Solver solver = new Solver(wl);
        List<String> result = solver.findContainers();
        List<String> expected = List.of("apple", "banana");
        assertEquals(sorted(expected), sorted(result));
    }

    // Uncomment the tests below. Replace each ???? with the value it should be.

    // @Test
    // @DisplayName("No word contains another.")
    // void testNoContainers() {
    //     WordList wl = new WordList(List.of("cat", "dog", "bird", "fish"));
    //     Solver solver = new Solver(wl);
    //     List<String> result = solver.findContainers();
    //     List<String> expected = ????;
    //     assertEquals(expected, result);
    // }

    // @Test
    // @DisplayName("Multiple words can contain the same word.")
    // void testMultipleContainers() {
    //     WordList wl = new WordList(List.of("work", "worker", "rework", "working", "homework"));
    //     Solver solver = new Solver(wl);
    //     List<String> result = solver.findContainers();
    //     int expectedCount = ????;
    //     assertEquals(expectedCount, result.size());
    // }

    // @Test
    // @DisplayName("A container can also be contained by another.")
    // void testNestedContainers() {
    //     WordList wl = new WordList(List.of("a", "an", "ant", "rant", "grant"));
    //     Solver solver = new Solver(wl);
    //     List<String> result = solver.findContainers();
    //     int expectedCount = ????;
    //     assertEquals(expectedCount, result.size());
    // }

    // @Test
    // @DisplayName("Test with small word file.")
    // void testFromFileSmall() {
    //     List<String> words = Words.getSmallWords();
    //     WordList wl = new WordList(words);
    //     Solver solver = new Solver(wl);
    //     List<String> result = solver.findContainers();
    //     assertInstanceOf(List.class, result);
    //     // Should find some containers in the curated list
    //     int expectedMin = ????;
    //     assertTrue(result.size() >= expectedMin);
    // }

    // ---------------- Optimization tests ----------------

    // @Test
    // void testMediumWordlist() {
    //     List<String> words = Words.getMediumWords();
    //     WordList wl = new WordList(words);
    //     Solver solver = new Solver(wl);
    //     long t0 = System.nanoTime();
    //     List<String> result = solver.findContainers();
    //     double elapsed = secondsSince(t0);
    //     assertInstanceOf(List.class, result);
    //     double expectedTime = 1.0;
    //     assertTrue(elapsed < expectedTime,
    //             String.format("500 words: %.2fs, need < %.1fs", elapsed, expectedTime));
    // }

    // @Test
    // @DisplayName("5,000 words - requires optimization to pass in time.")
    // void testLargeWordlist() {
    //     List<String> words = Words.getLargeWords();
    //     WordList wl = new WordList(words);
    //     Solver solver = new Solver(wl);
    //     long t0 = System.nanoTime();
    //     List<String> result = solver.findContainers();
    //     double elapsed = secondsSince(t0);
    //     assertInstanceOf(List.class, result);
    //     double expectedTime = 0.1; // Java-calibrated. Video (Python) used 0.5
    //     assertTrue(elapsed < expectedTime,
    //             String.format("5000 words: %.2fs, need < %.1fs", elapsed, expectedTime));
    // }

    // @Test
    // @DisplayName("10,000 words - stress test for optimized implementation.")
    // void testHugeWordlist() {
    //     List<String> words = Words.getHugeWords();
    //     WordList wl = new WordList(words);
    //     Solver solver = new Solver(wl);
    //     long t0 = System.nanoTime();
    //     List<String> result = solver.findContainers();
    //     double elapsed = secondsSince(t0);
    //     assertInstanceOf(List.class, result);
    //     double expectedTime = 0.2; // Java-calibrated. Video (Python) used 1.0
    //     assertTrue(elapsed < expectedTime,
    //             String.format("10000 words: %.2fs, need < %.1fs", elapsed, expectedTime));
    // }

    // @Test
    // @DisplayName("~200 words with very long lengths - requires optimization.")
    // void testLongWords() {
    //     List<String> words = Words.getLongWords();
    //     WordList wl = new WordList(words);
    //     Solver solver = new Solver(wl);
    //     long t0 = System.nanoTime();
    //     List<String> result = solver.findContainers();
    //     double elapsed = secondsSince(t0);
    //     assertInstanceOf(List.class, result);
    //     double expectedTime = 1.0;
    //     assertTrue(elapsed < expectedTime,
    //             String.format("long words: %.2fs, need < %.1fs", elapsed, expectedTime));
    // }
}
