/** Read this first. */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordList {
    private final List<String> words = new ArrayList<>();
    private final Set<String> wordSet = new HashSet<>();

    public WordList(List<String> words) {
        for (String word : words) {
            if (isValidWord(word) && !wordSet.contains(word)) {
                this.words.add(word);
                this.wordSet.add(word);
            }
        }
    }

    public boolean isValidWord(String word) {
        if (word.contains(" ")) {
            return false;
        }
        return true;
    }

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public Set<String> getWordSet() {
        return new HashSet<>(wordSet);
    }

    public boolean containsAsSubstring(String container, String contained) {
        if (contained.length() <= container.length()) {
            return container.contains(contained);
        }
        return false;
    }

    public int wordCount() {
        return words.size();
    }
}
