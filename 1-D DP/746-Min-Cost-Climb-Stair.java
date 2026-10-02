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