/*
    3727. Maximum Alternating Sum of Squares
    Topics
    You are given an integer array nums. You may rearrange the elements in any order.

    The alternating score of an array arr is defined as:

    score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
    Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.
*/
//Approach : Square and sort and pick larger and smaller
//O(nlogn)tc & O(1)sc
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long small = Arrays.stream(nums, 0, n / 2).asLongStream().sum();
        long large = Arrays.stream(nums, n / 2, n).asLongStream().sum();

        return large - small;
    }
}
commit #1