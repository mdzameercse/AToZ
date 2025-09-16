// Question Link: https://leetcode.com/problems/valid-anagram/


class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            count[t.charAt(i) - 'a'] -= 1;
        }

        return true;        
    }
}

// Java program to check if two strings are k anagram
// or not.

import java.io.*;
import java.util.*;

class GFG {
    public static boolean areKAnagrams(String s1, String s2, int k)
    {
        
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        for (char ch : map.keySet()) {
            count += map.get(ch); //no.of charator which are different
        }

        if (count > k)
            return false;
        else
            return true;
    }
    public static void main(String[] args)
    {
        String str1 = "anagram";
        String str2 = "grammar";
        int k = 2;
        if (areKAnagrams(str1, str2, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
