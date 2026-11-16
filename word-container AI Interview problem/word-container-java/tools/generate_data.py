"""
Generates data/words_medium.txt, words_large.txt, words_huge.txt and words_long.txt.

NOTE: These are NOT the original files from the video. Their contents were never
shown, only their sizes (from words.py and test_solver.py docstrings):
  medium = 500 words, large = 5,000 words, huge = 10,000 words,
  long   = ~200 words with very long lengths (~1000 chars).
This script recreates files of those sizes so the timing tests are meaningful.

Requires: pip install english-words
Deterministic (fixed seed), so re-running gives identical files.
"""
import os
import random

from english_words import get_english_words_set

DATA_DIR = os.path.join(os.path.dirname(__file__), "..", "data")
rng = random.Random(42)

pool = sorted(w for w in get_english_words_set(["web2"], lower=True) if w.isalpha() and w.isascii())


def write(name, words):
    with open(os.path.join(DATA_DIR, name), "w") as f:
        f.write("\n".join(words) + "\n")
    print(f"{name}: {len(words)} words")


write("words_medium.txt", rng.sample(pool, 500))
write("words_large.txt", rng.sample(pool, 5000))
write("words_huge.txt", rng.sample(pool, 10000))

# ~200 long random strings (~1000 chars). Some are built by embedding other
# strings from the list so that real containers exist.
letters = "abcdefghijklmnopqrstuvwxyz"
base = ["".join(rng.choice(letters) for _ in range(rng.randint(900, 1100))) for _ in range(160)]
long_words = list(base)
for _ in range(40):
    inner = rng.choice(base)
    left = "".join(rng.choice(letters) for _ in range(rng.randint(20, 60)))
    right = "".join(rng.choice(letters) for _ in range(rng.randint(20, 60)))
    long_words.append(left + inner + right)
rng.shuffle(long_words)
write("words_long.txt", long_words)
