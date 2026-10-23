/*
    3644. Maximum K to Sort a Permutation
    Medium
    You are given an integer array nums of length n, where nums is a permutation of the numbers in the range [0..n - 1].

    You may swap elements at indices i and j only if nums[i] AND nums[j] == k, where AND denotes the bitwise AND operation and k is a non-negative integer.

    Return the maximum value of k such that the array can be sorted in non-decreasing order using any number of such swaps. If nums is already sorted, return 0.
*/
class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int k=(1<<17)-1;
        for(int i=0;i<n;i++){
            if(nums[i]==i) continue;
            k&=nums[i];
        }
        return k==((1<<17)-1)?0:k;
    }
}