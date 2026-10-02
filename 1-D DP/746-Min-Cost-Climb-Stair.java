/*
    746. Min Cost Climbing Stairs
    Solved
    Easy
    Topics
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase.

    Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the staircase, which is the position just past the last step (index cost.length).
*/
// Using DP : bottom-up approach - O(n)tc & sc
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}
// Using DP : top-down approach - O(n)tc & sc
class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache , -1);
        return Math.min( dfs(cost, 0) , dfs(cost , 1));
    }

    private int dfs(int[] cost, int i ){
        if(i>= cost.length){
            return 0;
        }
        if(cache[i] !=-1){
            return cache[i];
        }
        cache[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
        return cache[i];
    }
}
