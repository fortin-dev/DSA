/* 
    1021. Remove Outermost Parentheses
    Easy
    A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
    Input: s = "(()())(())"
    Output: "()()()"
*/
// Level checking : O(n)tc & sc
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0)
                    ans.append(c);
                count++;
            } else {
                count--;
                if (count > 0)
                    ans.append(c);
            }
        }

        return ans.toString();
    }
}