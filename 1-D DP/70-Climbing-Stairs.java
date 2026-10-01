/*
    70. Climbing Stairs
    Easy
    Companies
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
*/

// using top-down dynamic programming approach - memoization 
// O(n)tc & sc 
public class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
// using bottom-up dynamic programming approach - memoization 
// O(n)tc & sc 
class Solution {
    public int climbStairs(int n) {
        if(n<= 2){
            return n;
        }
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
