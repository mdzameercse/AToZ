// Question Link: https://leetcode.com/problems/longest-palindromic-substring/description/


public class Solution {

    // Helper function to expand around the center and return the palindrome substring
    private String expandFromCenter(String s, int left, int right) {
        // Expand while we have valid bounds and the characters at the left and right pointers are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the valid palindrome substring (we return substring from left+1 to right-1)
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        // Edge case: If the string is empty or has only one character, it's already a palindrome
        if (s.length() <= 1) {
            return s;
        }

        // Initialize maxStr to hold the longest palindrome found
        String maxStr = s.substring(0, 1); // start with the first character (at least a 1-length palindrome)

        // Loop through the string, treating each character as the center of a potential palindrome
        for (int i = 0; i < s.length() - 1; i++) {
            // Check for odd-length palindromes (centered at i)
            String odd = expandFromCenter(s, i, i);
            // Check for even-length palindromes (centered between i and i+1)
            String even = expandFromCenter(s, i, i + 1);

            // Update maxStr if a longer palindrome is found
            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        // Return the longest palindrome found
        return maxStr;
    }
}

