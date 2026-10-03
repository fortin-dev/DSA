/*
    32. Longest Valid Parentheses
    Hard
    Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
    Example 1:
    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".
*/
// Simple looping approach : O(2*n)tc & O(1)sc
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int open = 0 , close = 0;
        int max=0;
        //Left to right

        for(int i =0 ; i<n ; i++){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(open == close) {
                max = Math.max(open+close , max);
            }else if (close > open){
                open = close =0;
            }
        }
        open =0;
        close =0;
        //Right to Left
        for(int i =n-1 ; i>=0 ; i--){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(open == close) {
                max = Math.max(open+close , max);
            }else if (open > close){
                open = close =0;
            }
        }
        return max;
    }
}