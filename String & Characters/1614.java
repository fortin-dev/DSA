/*
    1614. Maximum Nesting Depth of the Parentheses
    Solved
    Easy
    Topics
    Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
*/
class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int cnt =0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
                if(max<cnt){
                    max = cnt;
                }
            } else if (c == ')') {
                cnt--;
            }
        }
        return max;
    }
}