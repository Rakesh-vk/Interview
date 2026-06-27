// ============================================================
// Algorithm Name: Moore's Voting Algorithm - Majority Element II
// ============================================================

// ------------------------------------------------------------
// How It Works:
// ------------------------------------------------------------
// We need to find all elements appearing MORE than n/3 times.
// At most 2 such elements can exist in any array.
//
// Phase 1 - Find Candidates (Extended Boyer-Moore Voting):
//   Maintain 2 candidates and their counts.
//   - If current num matches candidate1 → increment count1
//   - Else if matches candidate2 → increment count2
//   - Else if count1 == 0 → assign candidate1 = num, count1 = 1
//   - Else if count2 == 0 → assign candidate2 = num, count2 = 1
//   - Else → decrement both counts (cancellation step)
//
// Phase 2 - Verify Candidates:
//   Reset counts and recount actual occurrences of both candidates.
//   Add to result only if count > n/3.
// ------------------------------------------------------------

// ------------------------------------------------------------
// Time & Space Complexity:
// ------------------------------------------------------------
// Time  : O(n) — two linear passes over the array
// Space : O(1) — only a fixed number of variables used
// ------------------------------------------------------------

// ------------------------------------------------------------
// Revision Trick:
// ------------------------------------------------------------
// Think "Two Seats, One Tournament":
//   → Only 2 candidates can hold a seat (appear > n/3 times).
//   → Phase 1: Let candidates fight for seats by cancellation.
//   → Phase 2: Recount to confirm they truly deserve the seat.
// ------------------------------------------------------------

package collections.Arrays.algorithms.MooreVoting;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {

        // Phase 1: Find up to 2 potential candidates using extended Boyer-Moore Voting
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                // Current number matches candidate1, strengthen its vote
                count1++;
            } else if (num == candidate2) {
                // Current number matches candidate2, strengthen its vote
                count2++;
            } else if (count1 == 0) {
                // Candidate1 seat is empty, assign new candidate
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                // Candidate2 seat is empty, assign new candidate
                candidate2 = num;
                count2 = 1;
            } else {
                // Current number matches neither; cancel one vote from each candidate
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify — recount actual occurrences of both candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;           // Count actual occurrences of candidate1
            else if (num == candidate2) count2++;      // Count actual occurrences of candidate2
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Only add candidates that truly appear more than n/3 times
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}

// ============================================================
// Dry Run: arr = {1, 2}  →  n = 2, threshold = n/3 = 0
// ============================================================
//
// Phase 1 — Find Candidates:
// ┌──────┬─────┬────────────┬────────┬────────────┬────────┐
// │ Step │ num │ candidate1 │ count1 │ candidate2 │ count2 │
// ├──────┼─────┼────────────┼────────┼────────────┼────────┤
// │ Init │  -  │     0      │   0    │     0      │   0    │
// │  1   │  1  │     1      │   1    │     0      │   0    │  ← count1==0, assign candidate1=1
// │  2   │  2  │     1      │   1    │     2      │   1    │  ← count2==0, assign candidate2=2
// └──────┴─────┴────────────┴────────┴────────────┴────────┘
//
// Phase 2 — Verify Counts:
//   num=1 → count1=1
//   num=2 → count2=1
//
// Check threshold (n/3 = 0):
//   count1=1 > 0 → add 1 ✓
//   count2=1 > 0 → add 2 ✓
//
// Output: [1, 2]
// ============================================================