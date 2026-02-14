// Question Link: https://leetcode.com/problems/reverse-words-in-a-string/description/


class Solution {
    public String reverseWords(String s) {
        // s=s.trim();
        // String ss[]=s.split("\\s+");
        String ss[]=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=ss.length-1;i>=0;i--)
        { 
           sb.append(ss[i]+" ");
           //if(i!=0)
           //sb.append(" ");
        }
      return sb.toString().trim();
    }
}
