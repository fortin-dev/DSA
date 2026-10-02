/*
    213. House Robber II
    Medium
    Topics
    Companies
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

// Using DP : usig same logic as House Robber I : but running the loop 2 times , 1st from 0 to n-1 and 2nd from 1 to n, and return max amongst them
class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0] , Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), helper(Arrays.copyOfRange(nums, 0, nums.length -1))));
    }

    private int helper(int[] nums){
        int rob1 =0;
        int rob2 =0;

        for(int num : nums){
            int temp = Math.max(rob1+num , rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
