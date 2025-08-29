// Question Link: https://leetcode.com/problems/isomorphic-strings/description/


class Solution {
    //tc 0(N) and Sp 0(1)
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256]; 
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != 0 && mapS[c1] != c2 || mapT[c2] != 0 && mapT[c2] != c1) {
                return false;
            }

            mapS[c1] = c2;
            mapT[c2] = c1;
        }

        return true;
    }
}
//tc 0(N) and Sp 0(N)
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                // already mapped, check consistency
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // not mapped yet
                if (mapped.contains(c2)) {
                    return false; // another char already maps to c2
                }
                map.put(c1, c2);
                mapped.add(c2);
            }
        }
        return true;
    }
}

