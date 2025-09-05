// Question Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Extra Space) - Time Complexity = O(n), Space Complexity = O(n)
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store the rearranged elements.
        int[] ans = new int[nums.length];

        // Create two lists to store positive and negative numbers separately.
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {
            // If the number is positive, add it to the positive list.
            if (nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                // If the number is negative, add it to the negative list.
                negative.add(nums[i]);
            }
        }

        // Iterate through half the length of the input array (since it's even length).
        for (int i = 0; i < nums.length / 2; i++) {
            // Place a positive number at the even index.
            ans[2 * i] = positive.get(i);

            // Place a negative number at the odd index.
            ans[2 * i + 1] = negative.get(i);
        }

        // Return the rearranged array.
        return ans;
    }
    */


    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(n)
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store the rearranged elements.
        int[] ans = new int[nums.length];

        // Initialize posIndex to start at 0 for positive numbers.
        int posIndex = 0;

        // Initialize negIndex to start at 1 for negative numbers.
        int negIndex = 1;

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {
            // If the current number is positive,
            if (nums[i] > 0) {
                // place it at the current posIndex in ans array.
                ans[posIndex] = nums[i];

                // Increment posIndex by 2 to point to the next even index.
                posIndex += 2;
            } else { // If the current number is negative,
                // place it at the current negIndex in ans array.
                ans[negIndex] = nums[i];
                
                // Increment negIndex by 2 to point to the next odd index.
                negIndex += 2;
            }
        }

        // Return the rearranged array.
        return ans;
    }
}

//for even no.of elemnts / even also
// Approach

// Separate Positives and Negatives:
// Traverse the array and store positive (and zero) numbers in one list.
// Store negative numbers in another list.
// Merge Alternately:
// Start with a positive number, then alternate between positive and negative.
// If one list gets exhausted, append the remaining elements of the other list.
public class RearrangeBySign {
    public static void rearrange(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        // Step 1: Separate positives and negatives
        for (int num : arr) {
            if (num >= 0)
                positives.add(num);
            else
                negatives.add(num);
        }

        int i = 0, p = 0, n = 0;
        boolean positiveTurn = true; // start with positive

        // Step 2: Merge alternately
        while (p < positives.size() && n < negatives.size()) {
            if (positiveTurn) {
                arr[i++] = positives.get(p++);
            } else {
                arr[i++] = negatives.get(n++);
            }
            positiveTurn = !positiveTurn; // alternate
        }

        // Step 3: Append remaining elements
        while (p < positives.size()) {
            arr[i++] = positives.get(p++);
        }
        while (n < negatives.size()) {
            arr[i++] = negatives.get(n++);
        }
    }
// Time Complexity
// O(2n) for traversing and rearranging.
// Space Complexity
// O(n) (because we use extra lists to store positives and negatives).
    //notes
// Total = O(n) + O(n) + O(n) → O(3n)
// Which simplifies to O(n).

// Why Do We Still Call It O(n)?

// Big-O focuses on growth rate as n → ∞.

// 2n, 3n, 5n → all grow linearly with n.

// Constants (2, 3, etc.) are dropped
