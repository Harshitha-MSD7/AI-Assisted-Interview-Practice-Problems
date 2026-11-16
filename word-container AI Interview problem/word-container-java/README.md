# Word Container (Java)

A Java port of the "Word Container" AI-assisted coding exercise from the Hello Interview walkthrough video (originally in Python).

## The problem

Someone built a word analysis system but left some bugs and unfinished work. The `WordList` class manages a collection of words and can check substring relationships. The `Solver` class should find all words that contain other words from the list as substrings.

Example: given `[apple, app, banana, nana]`, the answer is `[apple, banana]`. `apple` contains `app`, and `banana` contains `nana`.

## Your tasks

1. **Explore the code.** Figure out how the existing code works.
2. **Run `Main`** to see the current output.
3. **Run the unit tests.** Some test files have commented-out tests; uncomment them.
4. **Fix the bugs.** The `WordList` class has two bugs. Commented-out tests use `????` as expected values. Figure out what they should be and make the tests pass.
5. **Implement the Solver.** Complete `findContainers()` in `Solver.java` to find all words that contain at least one other word as a substring.
6. **Optimize.** Uncomment `testMediumWordlist`, `testLargeWordlist`, `testHugeWordlist` and `testLongWords` in `SolverTest.java` and make them pass.

Practice tip: set a 60-minute timer and use an AI chat as your "AI Assist" tab. Keep it in a separate window and don't let it edit your files, the same way the interview AI only talks in a chat panel.

## Project layout

```
data/                    word lists (small, medium, large, huge, long)
src/main/java/
  Main.java              runs your Solver on example words
  Solver.java            you implement this
  WordList.java          read this first (has 2 bugs)
  Words.java             loads the word lists
src/test/java/
  WordListTest.java
  SolverTest.java
tools/generate_data.py   recreates the medium/large/huge/long data files
```

## How to run

**IntelliJ (easiest):** File → Open → select this folder (it's a Maven project). Run `Main` with the green arrow, and run tests by right-clicking `src/test/java` → Run 'All Tests'.

The working directory must be the project root so `data/` is found (IntelliJ's default for Maven projects).

**Command line (needs Maven installed):**

```
mvn test                      # run all tests
mvn test -Dtest=WordListTest  # run one test class
mvn compile exec:java         # run Main
```

Requires Java 17+.

## How this port differs from the video

- **Language:** Python → Java. `unittest` → JUnit 5. Method names are camelCase (`contains_as_substring` → `containsAsSubstring`). The Python stub returned `None`, so the Java stub returns `null`.
- **`????` placeholders:** in Python, `expected = "????"` still runs. In Java it wouldn't compile, so the placeholders sit inside the commented-out tests. Fill them in when you uncomment.
- **Data files:** `words_small.txt` matches the video exactly. The contents of medium/large/huge/long were never shown, only their sizes (500, 5,000, 10,000, and ~200 words of ~1000 chars). They were regenerated to those sizes by `tools/generate_data.py`, using real English words for medium/large/huge and random letters for long.
- **Time limits:** Java runs much faster than Python, so the video's limits for large (0.5s) and huge (1.0s) let a naive solution pass. They were tightened to **0.1s** and **0.2s** so the optimization stage still matters. Medium and long keep the video's 1.0s. If a naive solution passes the large test on your machine, lower the limit further.
- **`testFromFileSmall`:** in the video it starts commented out, but the screenshots don't show whether its value was `????` or already filled in, so it uses `????` here.
