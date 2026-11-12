/*
    3105. Longest Strictly Increasing or Strictly Decreasing Subarray
    Easy
    You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.
    Example 1:
    Input: nums = [1,4,3,3,2]
    Output: 2
    Explanation:
    The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
    The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
    Hence, we return 2.
*/
// Simple Linear Complexity Solution : O(n)tc
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1 , dec = 1 , maxInc = 1, maxDec = 1 ;
        for(int i =1 ; i<nums.length ; i++){
            if(nums[i] < nums[i-1]){
                dec++;
                maxDec = Math.max(maxDec, dec);
            }else{
                dec=1;
            }
            if(nums[i] > nums[i-1]){
                inc++;
                maxInc = Math.max(maxInc , inc);
            }else{
                inc=1;
            }
        }
        return Math.max(maxInc , maxDec);
    }
}