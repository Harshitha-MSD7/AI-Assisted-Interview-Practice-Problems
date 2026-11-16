/** Tests for WordList class functionality. */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class WordListTest {

    @Test
    void testWordCount() {
        WordList wl = new WordList(List.of("apple", "banana", "cherry"));
        assertEquals(3, wl.wordCount());
    }

    @Test
    void testRemovesDuplicates() {
        WordList wl = new WordList(List.of("apple", "apple", "banana"));
        assertEquals(2, wl.wordCount());
    }

    @Test
    void testContainsBasic() {
        WordList wl = new WordList(List.of());
        assertTrue(wl.containsAsSubstring("apple", "app"));
        assertTrue(wl.containsAsSubstring("banana", "nana"));
        assertFalse(wl.containsAsSubstring("cat", "dog"));
    }

    @Test
    void testContainsAtDifferentPositions() {
        WordList wl = new WordList(List.of());
        // At start
        assertTrue(wl.containsAsSubstring("hello", "he"));
        // At end
        assertTrue(wl.containsAsSubstring("hello", "lo"));
        // In middle
        assertTrue(wl.containsAsSubstring("hello", "ell"));
    }

    // Uncomment the tests below. Replace each ???? with the value it should be.

    // @Test
    // void testContainsSameWord() {
    //     WordList wl = new WordList(List.of());
    //     boolean expected = ????;
    //     assertEquals(expected, wl.containsAsSubstring("apple", "apple"));
    // }

    // @Test
    // void testContainsLongerWord() {
    //     WordList wl = new WordList(List.of());
    //     boolean expected = ????;
    //     assertEquals(expected, wl.containsAsSubstring("app", "apple"));
    // }

    // @Test
    // void testValidWordNormal() {
    //     WordList wl = new WordList(List.of());
    //     assertEquals(true, wl.isValidWord("hello"));
    // }

    // @Test
    // void testValidWordEmpty() {
    //     WordList wl = new WordList(List.of());
    //     assertEquals(false, wl.isValidWord(""));
    // }

    // @Test
    // void testValidWordSpaces() {
    //     WordList wl = new WordList(List.of());
    //     assertEquals(false, wl.isValidWord("hello world"));
    // }

    // @Test
    // void testFiltersInvalidWords() {
    //     WordList wl = new WordList(List.of("apple", "", "banana", "hello world", "cherry"));
    //     assertEquals(3, wl.wordCount());
    // }
}
