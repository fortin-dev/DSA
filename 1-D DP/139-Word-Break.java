/*
    139. Word Break
    Medium
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
    Example 1:
    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
*/

// Dynamic Programming bottom-up approach : O(n*m*t)tc & O(n)sc where n is length of string , m is no. of words in wordDict and t is max. length of a word in wordDict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i = s.length()-1 ; i>=0 ; i--){
            for(String w : wordDict){
                if((i+w.length()) <= s.length() && s.substring(i, i+w.length()).equals(w)){
                    dp[i] = dp[i+w.length()];
                } 
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];
    }
}
