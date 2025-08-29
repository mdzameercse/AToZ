// Question Link: https://leetcode.com/problems/reverse-words-in-a-string/description/


class Solution {

    // Time Complexity = O(n), Space Complexity = O(n)
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();        
        String str = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                if (!str.isEmpty()) {  
                    stack.push(str);
                }

                str = "";  
            } else {
                str += s.charAt(i); 
            }
        }

        if (!str.isEmpty()) {
            stack.push(str);
        }

        String ans = "";
        
        while (!stack.isEmpty()) {
            ans += stack.pop();   

            if (!stack.isEmpty()) { 
                ans += " ";
            }
        }

        return ans;
    }
}
 // Time Complexity = O(n), Space Complexity = O(n)
public class Main {
    public static void main(String[] args) {
        String str = "Hello World Java";

        // split words, reverse them, and join again
        String[] words = str.trim().split("\\s+"); // handles multiple spaces
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        System.out.println("Reversed words: " + sb.toString().trim());
    }
}

