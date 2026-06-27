package Langauge.String.StringMatching.KMP;

/*
 * ============================================================
 * KMP (Knuth-Morris-Pratt) String Matching Algorithm
 * ============================================================
 *
 * HOW THE ALGORITHM WORKS
 * ------------------------------------------------------------
 *
 * Problem with Naive Algorithm:
 * -----------------------------
 * Whenever a mismatch occurs, the naive algorithm starts
 * comparing the pattern from the beginning, resulting in
 * many unnecessary comparisons.
 *
 * Example:
 *
 * Text    : ABABABAC
 * Pattern : ABABAC
 *
 * After matching "ABABA", a mismatch occurs.
 *
 * Naive Algorithm:
 * Starts matching the pattern again from index 0.
 *
 * KMP Algorithm:
 * Uses the LPS (Longest Prefix Suffix) array to decide
 * where to continue matching.
 *
 * Instead of restarting from the beginning,
 * it skips comparisons that are already known to match.
 *
 * ------------------------------------------------------------
 * What is LPS?
 * ------------------------------------------------------------
 *
 * LPS[i] =
 * Length of the Longest Proper Prefix
 * which is also a Proper Suffix
 * for substring pattern[0...i].
 *
 * Example:
 *
 * Pattern : ABABAC
 *
 * Index : 0 1 2 3 4 5
 * Char  : A B A B A C
 * LPS   : 0 0 1 2 3 0
 *
 * Suppose mismatch happens after matching:
 *
 * ABABA
 *
 * Instead of starting again from index 0,
 * KMP jumps to index 3 because "ABA" has already matched.
 *
 * ------------------------------------------------------------
 * Searching Process
 * ------------------------------------------------------------
 *
 * 1. Build the LPS array.
 *
 * 2. Traverse the text using pointer i.
 *
 * 3. Traverse the pattern using pointer j.
 *
 * 4. If characters match:
 *      i++
 *      j++
 *
 * 5. If entire pattern matched:
 *      return i - patternLength
 *
 * 6. If mismatch occurs:
 *
 *      if (j != 0)
 *          j = lps[j - 1];
 *
 *      else
 *          i++;
 *
 * Notice:
 * The text pointer (i) NEVER moves backward.
 *
 * ------------------------------------------------------------
 * Time Complexity
 * ------------------------------------------------------------
 *
 * Building LPS : O(m)
 * Searching    : O(n)
 *
 * Total        : O(n + m)
 *
 * where
 * n = length of text
 * m = length of pattern
 *
 * ------------------------------------------------------------
 * Space Complexity
 * ------------------------------------------------------------
 *
 * O(m)   // LPS array
 *
 * ============================================================
 */

public class KMPStringMatching {
    public static void main(String[] args) {

        String text = "abcabcabc";
        String pattern = "cab";

        System.out.println(match(text, pattern));
    }

    public static int match(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        // Build the LPS array before searching.
        // It tells us where to continue matching after a mismatch.
        int[] lps = buildLPS(pattern);

        // i -> points to the text
        // j -> points to the pattern
        int i = 0;
        int j = 0;

        /*
         * Traverse the text only once.
         *
         * Rules:
         *
         * Match:
         *      i++
         *      j++
         *
         * Mismatch:
         *      if (j != 0)
         *          jump using LPS
         *      else
         *          move text pointer
         *
         * Complete Match:
         *      return starting index
         */
        while (i < n) {

            // Current characters match.
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            // Entire pattern matched.
            // Starting index = current text index - pattern length.
            if (j == m) {
                return i - m;
            }

            /*
             * Characters do not match.
             *
             * Instead of restarting the pattern,
             * use the LPS array to skip unnecessary comparisons.
             */
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                // Some characters already matched.
                if (j != 0) {

                    // Jump to the previous longest prefix.
                    j = lps[j - 1];

                } else {

                    // Nothing matched.
                    // Move to the next text character.
                    i++;
                }
            }
        }

        // Pattern not found.
        return -1;
    }

    /*
     * Builds the LPS (Longest Prefix Suffix) array.
     *
     * LPS[i] =
     * Length of the longest proper prefix
     * which is also a suffix
     * for substring pattern[0...i].
     *
     * Example:
     *
     * Pattern : ABABAC
     *
     * Index : 0 1 2 3 4 5
     * Char  : A B A B A C
     * LPS   : 0 0 1 2 3 0
     *
     * We compare the pattern with itself to find repeated prefixes.
     */
    public static int[] buildLPS(String pattern) {

        int m = pattern.length();

        // LPS array to store prefix lengths.
        int[] lps = new int[m];

        // Length of the previous longest prefix suffix.
        int len = 0;

        // First character always has LPS = 0.
        lps[0] = 0;

        // Start from second character.
        int i = 1;

        while (i < m) {

            // Characters match.
            if (pattern.charAt(i) == pattern.charAt(len)) {

                // Increase prefix length.
                len++;

                // Store it.
                lps[i] = len;

                // Move to next character.
                i++;

            } else {

                /*
                 * Mismatch occurred.
                 *
                 * Instead of starting from the beginning,
                 * try the previous longest prefix.
                 */
                if (len != 0) {

                    len = lps[len - 1];

                } else {

                    // No prefix available.
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
