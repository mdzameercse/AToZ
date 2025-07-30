// Question Link: https://leetcode.com/problems/majority-element/description/


class Solution {
    // 1st Approach: Brute Force(Using 2 Loops) - Time Complexity = O(n^2), Space  Complexity = O(1)
    public int majorityElement(int[] nums) {
        // Variable to store the majority element
        int ele = 0;

        // Variable to store the count of the current majority element
        int maxCount = 0;

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Variable to count occurrences of nums[i]
            int count = 0;

            // Count how many times nums[i] appears in the array
            for (int j = i; j < nums.length; j++) {

                // Increment count if nums[i] is found
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // Update the majority element if the current element's count is greater than maxCount
            if (count > maxCount) {
                maxCount = count; // Update the maximum count
                ele = nums[i]; // Update the majority element
            }
        }

        // Return the majority element
        return ele;
    }

    /*
    // 2nd Approach: Another Brute Force(Using 2 Loops) - Time Complexity = O(n^2), Space  Complexity = O(1)
    public int majorityElement(int[] nums) {
        
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Variable to count occurrences of nums[i]
            int count = 0;

            // Count how many times nums[i] appears in the array
            for (int j = i; j < nums.length; j++) {
                // Increment count if nums[i] is found
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // Check if the count of nums[i] is more than half of the array length
            if (count > nums.length / 2) {
                // Return nums[i] if it is the majority element
                return nums[i];
            }
        }

        // Return -1 if no majority element is found (shouldn't happen with the given problem constraints)
        return -1;
    }
    */
       
    // 5th Approach: Better Approach(Using HashMap) - Time Complexity = O(n), Space  Complexity = O(n)
   public int majorityElement(int[] nums) {
    // Use Map interface for flexibility
    Map<Integer, Integer> map = new HashMap<>();

    // Count occurrences of each number
    for (int num : nums) {
        int count = map.getOrDefault(num, 0);  //the value mapped to num if it exists 0 if num is not in the map
        map.put(num, count + 1);
    }

    // Find the number with count > n / 2
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > nums.length / 2) {
            return entry.getKey();  
        }
    }

    // Should not reach here as a majority element is guaranteed
    return -1;
}

    // 6th Approach: Optimal Approach(Using Moore’s Voting Algorithm) - Time Complexity = O(n), Space  Complexity = O(1)
    public int majorityElement(int[] nums) {
        int n = nums.length; // Length of the array
        int count = 0; // Variable to keep track of the count of the current candidate
        int ele = 0; // Variable to store the current candidate for majority element

        // Apply the Boyer-Moore Voting Algorithm
        for (int i = 0; i < n; i++) {
            // If count is zero, set the current element as the new candidate
            if (count == 0) {
                count = 1;
                ele = nums[i];
            } 
            // If the current element is the same as the candidate, increment the count
            else if (ele == nums[i]) {
                count++;
            } 
            // If the current element is different from the candidate, decrement the count
            else {
                count--;
            }
        }

        // Verify if the candidate is actually the majority element
        int count1 = 0; // Variable to count occurrences of the candidate
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele) {
                count1++;
            }
        }

        // Check if the count of the candidate is greater than n / 2
        if (count1 > (n / 2)) {
            return ele; // Return the majority element
        }

        // Return -1 if no majority element is found (though the problem guarantees one)
        return -1;
    }
    
    
    // 7th Approach: Optimal Approach(Using Moore’s Voting Algorithm) - Time Complexity = O(n), Space  Complexity = O(1)
    public int majorityElement(int[] nums) {
        // Initialize count to 0 and ele to hold the current candidate for majority element
        int count = 0;
        int ele = 0;
        
        // Iterate through each element in the array
        for (int num : nums) {
            // If count is 0, update the current candidate to the current element
            if (count == 0) {
                ele = num;
            }
            
            // If the current element is the same as the candidate, increment the count
            if (num == ele) {
                count++;
            } else {
                // If the current element is different from the candidate, decrement the count
                count--;
            }
        }
        
        // Return the candidate element which is the majority element
        return ele;
    }
}
