/*
    3863. Minimum Operations to Sort a String
    Medium
    You are given a string s consisting of lowercase English letters.

    In one operation, you can select any substring of s that is not the entire string and sort it in non-descending alphabetical order.

    Return the minimum number of operations required to make s sorted in non-descending order. If it is not possible, return -1.
*/
// At most three operation 
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;
        char mn = s.charAt(0), mx = s.charAt(0);
        for (int i = 1; i < n; ++i) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;
        for (int i = 1; i < n - 1; ++i) {
            char c = s.charAt(i);
            if (c == mn || c == mx) return 2;
        }
        return 3;
    }
}