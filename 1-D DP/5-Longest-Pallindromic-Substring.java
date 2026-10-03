/*
    5. Longest Palindromic Substring
    Medium
    Given a string s, return the longest palindromic substring in s.
    Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
*/
// Using Dynamic Programming : O(n^2)tc & sc
class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0 , resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for(int i = n-1; i>=0 ; i--){
            for(int j = i ; j< n ; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){

                    dp[i][j] = true;
                    if(resLen < (j-i+1)){
                        resIdx = i;
                        resLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(resIdx , resIdx+resLen);
    }
}
