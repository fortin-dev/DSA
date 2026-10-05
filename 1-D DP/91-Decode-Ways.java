/*
    91. Decode Ways
    Medium
    You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
    "1" -> 'A'
    "2" -> 'B'
    ...
    "25" -> 'Y'
    "26" -> 'Z'
    However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
    For example, "11106" can be decoded into:
    "AAJF" with the grouping (1, 1, 10, 6)
    "KJF" with the grouping (11, 10, 6)
    The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
    Note: there 
*/
// Using Dynamic Programming : top-down approach - memoization - O(n)tc & sc
class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(s, 0 , dp);
    }
    private int dfs(String s , int i , Map<Integer, Integer> dp ){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        
        int res = dfs(s, i+1, dp);
        if(i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7')){
            res+= dfs(s, i+2, dp);
        }
        dp.put(i, res);
        return res;
    }
}

// Using Dynamic Programming : bottom-up approach - storing result in reverse order in and array
// O(n)tc & sc
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length()
                    && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
