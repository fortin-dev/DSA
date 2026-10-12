/*
    14. Longest Common Prefix

    Easy
    Topics
    premium lock icon
    Companies
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".
*/

// O(m*n)tc where m is no. of strings and n is length of longest string
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String pref = strs[0];
        int prefLen = pref.length();

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLen);
            }
        }

        return pref;        
    }
}