/*
    22. Generate Parentheses
    Medium
    Topics
    Companies
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
// Brute Force approach : validating every possible combination of parentheses and only inseting the valid parentheses : O(2^2n *n)tc & sc
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",res,n);
        return res;
    }
    private boolean valid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0)
                return false;
        }
        return open == 0;
    }
    private void dfs(String s , List<String> res , int n ){
        if(n*2 == s.length()){
            if(valid(s)) res.add(s);
            return;
        }
        dfs(s+'(', res, n);
        dfs(s+')', res, n);
    }
}

// Using Backtracking : only inserting the valid parantheses :  O(4^n/sqrt(n))tc & O(n)sc
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }
    private void backtrack(int open, int close, int n, List<String> res, StringBuilder stack){
        if(open == close && open == n){
            res.add(stack.toString());
            return;
        }
        if(open < n){
            stack.append('(');
            backtrack(open+1, close, n , res, stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if(close < open){
            stack.append(')');
            backtrack(open, close+1, n , res, stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
