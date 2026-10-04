/*
    647. Palindromic Substrings
    Medium
    Hint
    A string is a palindrome when it reads the same backward as forward.
    A substring is a contiguous sequence of characters within the string.
*/
// Using two pointer : O(n)tc & sc
class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            //for even length
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
