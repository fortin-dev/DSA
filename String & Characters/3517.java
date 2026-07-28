// 3517. Smallest Palindromic Rearrangement I
// You are given a palindromic string s.

// Return the lexicographically smallest palindromic permutation of s.
// Example 2:
// Input: s = "babab"
// Output: "abbba"
// Explanation:
// Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.
// Example 3:
// Input: s = "daccad"
// Output: "acddca"
// Explanation:
// Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.
// using frequency array of size 26 - 
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int n = s.length();
        char[] res = new char[n];
        int l = 0, r = n - 1;
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                res[l++] = (char) ('a' + i);
                res[r--] = (char) ('a' + i);
                freq[i] -= 2;
            }
            if (freq[i] == 1) {
                res[n / 2] = (char) ('a' + i);
            }
        }
        return new String(res);
    }
}