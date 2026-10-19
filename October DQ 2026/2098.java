/*
    2089. Find Target Indices After Sorting Array
    Easy
    You are given a 0-indexed integer array nums and a target element target.

    A target index is an index i such that nums[i] == target.

    Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
*/
// Using Sortin : O(n log n)tc
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0 ;i < nums.length; i++){
            if(nums[i] == target){
                res.add(i);
            }
        }
        return res;
    }
}