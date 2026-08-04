package Langauge.String.StringMatching;

/*
 * ------------------------------------------------------------
 * Naive String Matching Algorithm
 * ------------------------------------------------------------
 * Time Complexity:
 * Worst Case : O((n - m + 1) * m) ≈ O(n * m)
 * Best Case  : O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * where,
 * n = length of text
 * m = length of pattern
 * ------------------------------------------------------------
 */

public class naiveStringMatching {
    public static void main(String[] args) {
        String text = "abcabcabc";
        String pattern = "cab";
        System.out.println(match(text, pattern));
    }
    public static int match(String text, String pattern) {
        // Length of text and pattern
        int n = text.length();
        int m = pattern.length();
        /*
         * Try matching the pattern starting from every possible index.
         *
         * Last possible starting index = n - m
         *
         * Example:
         * Text    = "abcdef" (length = 6)
         * Pattern = "def"    (length = 3)
         *
         * Valid starting indices:
         * 0, 1, 2, 3
         *
         * Therefore loop till i <= n - m.
         */
        for (int i = 0; i <= n - m; i++) {
            // j -> index for pattern
            // k -> index for text
            int j;
            int k = i;
            /*
             * Compare pattern with the current substring of text.
             *
             * Stop immediately if any character does not match.
             */
            for (j = 0; j < m; j++) {
                // Character mismatch -> pattern cannot start at index i
                if (text.charAt(k) != pattern.charAt(j)) {
                    break;
                }
                // Move to the next character in text
                k++;
            }
            /*
             * If j reached m,
             * it means every character matched successfully.
             */
            if (j == m) {
                return i;
            }
        }
        // Pattern not found anywhere in the text
        return -1;
    }
}