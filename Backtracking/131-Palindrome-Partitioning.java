/*
    131. Palindrome Partitioning
    Medium
    Topics
    Companies
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
    Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
*/

// Using backtracking : O(n*2^n)tc & O(n)extra space + O(n*2^n)sc for output list
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        util(res, list, s, 0);
        return res;
    }

    public void util(List<List<String>> res, List<String> list, String s, int ind) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            String subStr = s.substring(ind, i + 1);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                util(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
