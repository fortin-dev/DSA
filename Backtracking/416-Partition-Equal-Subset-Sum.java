/*
    416. Partition Equal Subset Sum
    Medium
    Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
    Example 1:

    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11]. 
*/

// Dynamic Programming top-down approach : O(n*target)tc & O(target)sc
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i = 0; i<n ;i++){
            sum+=nums[i];
        }
        if(sum%2 != 0){
            return false;
        }
        memo = new Boolean[n][sum/2+1];
        return dfs(nums , 0 , sum/2);
    }
    public boolean dfs(int[] nums, int i , int target){
        if(i == nums.length){
            return target == 0;
        }
        if(target<0){
            return false;
        }
        if(memo[i][target] != null){
            return memo[i][target];
        }
        memo[i][target] = dfs(nums, i+1, target)|| dfs(nums, i+1, target-nums[i]);

        return memo[i][target];
    }
}

// Dynamic Programming : optimised approach with key intuition of  : Can we pick some numbers whose sum equals target = total_sum / 2?
//For each number, update the DP from right to left so that each number is used only once.
// O(n*target)tc & O(target)sc
public class Solution {
    public boolean canPartition(int[] nums) {
        if (sum(nums) % 2 != 0) {
            return false;
        }

        int target = sum(nums) / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    private int sum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}