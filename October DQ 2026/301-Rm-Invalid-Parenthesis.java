/*
    301. Remove Invalid Parentheses
    Hard
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

    Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
*/

//Approach (Khandani Backtracking  -> all possible options)
//O(2^n)tc, 2 choice for each index in worst case
//O(M*N)sc, M = total possible strings in set, N = Average length of each string
class Solution {
    private Set<String> st = new HashSet<>();
    private int n;
    private int maxLen;

    private void solve(String s, int i, StringBuilder curr, int count) {
        if (count < 0) 
            return;

        if (i == n) {
            if (count == 0) {
                if (curr.length() > maxLen) {
                    maxLen = curr.length();
                    st.clear();
                }

                if (curr.length() == maxLen) {
                    st.add(curr.toString());
                }
            }
            return;
        }

        char c = s.charAt(i);

        if (c != '(' && c != ')') {
            curr.append(c);
            solve(s, i + 1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        curr.append(c);

        solve(s, i + 1, curr, count + (c == '(' ? 1 : -1));

        curr.deleteCharAt(curr.length() - 1);
        solve(s, i + 1, curr, count);
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        maxLen = 0;
        st.clear();

        solve(s, 0, new StringBuilder(), 0);

        return new ArrayList<>(st);
    }
}