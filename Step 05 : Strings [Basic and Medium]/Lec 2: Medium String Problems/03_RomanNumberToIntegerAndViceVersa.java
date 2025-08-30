// Question Link: https://leetcode.com/problems/roman-to-integer/description/


import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            // If the next value is larger, subtract current
             //boundery not exit
            if (i + 1 < s.length() && curr < map.get(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }
        
        return ans;
    }
}



Example: "MCMXCIV"
M (1000) → add → ans=1000

C (100) before M (1000) → subtract → ans=900

M (1000) → add → ans=1900

X (10) before C (100) → subtract → ans=1890

C (100) → add → ans=1990

I (1) before V (5) → subtract → ans=1989

V (5) → add → ans=1994 ✅


     
✅ Approach 2: Preprocess Subtractive Cases
Handle subtractive pairs (IV, IX, XL, XC, CD, CM) first, then the rest.

java
Copy code
class Solution {
    public int romanToInt(String s) {
        s = s.replace("IV", "a"); // 4
        s = s.replace("IX", "b"); // 9
        s = s.replace("XL", "c"); // 40
        s = s.replace("XC", "d"); // 90
        s = s.replace("CD", "e"); // 400
        s = s.replace("CM", "f"); // 900

        int ans = 0;
        for (char c : s.toCharArray()) {
            switch(c) {
                case 'I': ans += 1; break;
                case 'V': ans += 5; break;
                case 'X': ans += 10; break;
                case 'L': ans += 50; break;
                case 'C': ans += 100; break;
                case 'D': ans += 500; break;
                case 'M': ans += 1000; break;
                case 'a': ans += 4; break;
                case 'b': ans += 9; break;
                case 'c': ans += 40; break;
                case 'd': ans += 90; break;
                case 'e': ans += 400; break;
                case 'f': ans += 900; break;
            }
        }
        return ans;
    }
}
