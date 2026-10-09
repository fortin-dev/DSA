/*
    1541. Minimum Insertions to Balance a Parentheses String
    Medium
    Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

    Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
    Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
    In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

    For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
    You can insert the characters '(' and ')' at any position of the string to balance it if needed.

    Return the minimum number of insertions needed to make s balanced.
*/

// Greedy Approach : O(n)tc 
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int res = 0;
        int count = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '(') {
                count++;
                i++;
            } else {
                if(count>0){
                    count--;
                }else{
                    res++;
                }
                if (i+1 < n && s.charAt(i+1) == ')') {
                    i += 2;
                }
                else{
                    res++;
                    i++;
                }
            }
        }
        return res+count*2;
    }
}