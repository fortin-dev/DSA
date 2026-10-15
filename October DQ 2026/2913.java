/*
    2913. Subarrays Distinct Element Sum of Squares I
    Easy
    You are given a 0-indexed integer array nums.

    The distinct count of a subarray of nums is defined as:

    Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
    Return the sum of the squares of distinct counts of all subarrays of nums.

    A subarray is a contiguous non-empty sequence of elements within an array.
*/
// Using Hash Set : O(n^2)tc & O(n)sc
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                int d = s.size();
                res += d * d;
            }
        }
        return res;
    }
}