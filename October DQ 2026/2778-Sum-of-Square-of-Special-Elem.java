/*
    2778. Sum of Squares of Special Elements 
    Easy
    You are given a 1-indexed integer array nums of length n.

    An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.

    Return the sum of the squares of all special elements of nums.
*/
class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums.length % i == 0)
                ans += nums[i - 1] * nums[i - 1];
        }
        return ans;
    }
}