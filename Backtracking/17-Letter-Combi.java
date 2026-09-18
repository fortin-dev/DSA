/*
    17. Letter Combinations of a Phone Number
    Medium
    Topics
    Companies
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
/*
    Using Backtrackig : using a array to store character related to a digit (index) eg at index 2- we store "abc"......., we extract the character set mapped to a digit : for every character in that character set : we append it and recurse to next index.

    TC : O(n*4^n)(because 7 & 9 have 4 character) 
    SC : O(n) for extra space & O(n*4^n) for output list
 */
class Solution {
    List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        backtrack(0, "", digits);
        return res;
    }
    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}

// Using Backtracking but with StringBuilder: improves efficiency
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(digits, map, res, cur, 0);
        
        return res;
    }

    private void dfs(String digits, String[] map, List<String> res, StringBuilder cur, int idx) {
        //Base case to close
        if (idx == digits.length()) {
            res.add(new String(cur));
            return;
        }

        for (char letter : map[digits.charAt(idx) - '0'].toCharArray()) {
            cur.append(letter);
            dfs(digits, map, res, cur, idx + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
