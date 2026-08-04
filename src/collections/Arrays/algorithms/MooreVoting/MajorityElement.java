package collections.Arrays.algorithms.MooreVoting;

/*
==========================================================
Algorithm Name:
Moore's Voting Algorithm (Majority Element)

----------------------------------------------------------
How it Works:
1. Assume the first element as the majority candidate.
2. Traverse the array while maintaining a vote count.
3. If the current element matches the candidate, increase the vote count.
4. Otherwise, decrease the vote count.
5. If the vote count becomes 0, choose the current element as the new candidate
   and reset the vote count to 1.
6. If a majority element (appearing more than n/2 times) exists, the final
   candidate will always be the majority element.

Note:
This algorithm assumes that a majority element always exists.
If it may not exist, a second pass is required to verify the candidate.

----------------------------------------------------------
Time Complexity:
- Best Case   : O(n)
- Average Case: O(n)
- Worst Case  : O(n)

Space Complexity:
- O(1)

----------------------------------------------------------
Revision Trick:
Every different element cancels one vote of the current candidate.
Since the majority element appears more than n/2 times, it can never be
completely cancelled and remains the final candidate.

==========================================================
*/

public class MajorityElement {

    public static void main(String[] args) {

        // Input array
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        // Print the majority element
        System.out.println(majority(arr));
    }

    public static int majority(int[] arr) {

        // Assume first element as the majority candidate
        int candidate = arr[0];

        // Candidate initially has one vote
        int count = 1;

        // Length of array
        int n = arr.length;

        // Traverse the remaining elements
        for (int i = 1; i < n; i++) {

            // If current element matches the candidate,
            // increase its vote count
            if (candidate == arr[i]) {
                count++;
            }

            // Otherwise, decrease the vote count
            else {
                count--;
            }

            // If all votes are cancelled,
            // choose the current element as the new candidate
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }

        // Return the final candidate
        return candidate;
    }
}

/*
==========================================================
Dry Run

Input:
arr = {2, 2, 1, 1, 1, 2, 2}

Initially:
candidate = 2
count = 1

----------------------------------------------------------
i = 1
arr[i] = 2

candidate == arr[i]
count = 2

Current Candidate = 2

----------------------------------------------------------
i = 2
arr[i] = 1

candidate != arr[i]
count = 1

Current Candidate = 2

----------------------------------------------------------
i = 3
arr[i] = 1

candidate != arr[i]
count = 0

count == 0
candidate = 1
count = 1

Current Candidate = 1

----------------------------------------------------------
i = 4
arr[i] = 1

candidate == arr[i]
count = 2

Current Candidate = 1

----------------------------------------------------------
i = 5
arr[i] = 2

candidate != arr[i]
count = 1

Current Candidate = 1

----------------------------------------------------------
i = 6
arr[i] = 2

candidate != arr[i]
count = 0

count == 0
candidate = 2
count = 1

Current Candidate = 2

----------------------------------------------------------
Final Answer:
Majority Element = 2

Explanation:
Frequency of 2 = 4
Frequency of 1 = 3

Since 2 appears more than n/2 times
(4 > 7/2 = 3), it is the majority element.

==========================================================
*/