/*
    856. Score of Parentheses
    Medium
    Given a balanced parentheses string s, return the score of the string.

    The score of a balanced parentheses string is based on the following rule:

    "()" has score 1.
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.
*/
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int inside = stack.pop();

                if (inside == 0) {
                    stack.push(stack.pop() + 1);
                } else {
                    stack.push(stack.pop() + 2 * inside);
                }
            }
        }

        return stack.pop();
    }
}