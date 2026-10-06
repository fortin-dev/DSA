/*
    152. Maximum Product Subarray
    Medium
    Given an integer array nums, find a subarray that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    Note that the product of an array with a single element is the value of that element.
    ​​​​​​​Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
 */
// Using Kadane's Algorithm : O(n)tc 
// using max , min , since there will be -ve no. too, even no. of -ve becomes positive
public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}