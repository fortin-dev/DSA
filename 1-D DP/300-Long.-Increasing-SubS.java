/*
    300. Longest Increasing Subsequence
    Medium
    Topics
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    Example 1:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/

//Dynamic Programming : top-down approach : O(n^2)tc & O(n)sc
public class Solution {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dfs(nums, i));
        }
        return maxLIS;
    }

    private int dfs(int[] nums, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int LIS = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                LIS = Math.max(LIS, 1 + dfs(nums, j));
            }
        }

        memo[i] = LIS;
        return LIS;
    }
}