// Question Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/


class Solution {
    public static int maxDepth(String s) {
        int currCount=0, maxCount=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
             currCount++;
            else if(c==')')
            currCount--;
             maxCount=Math.max( maxCount,currCount);
        }
        return  maxCount;
    }
}

