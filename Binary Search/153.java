// 153. Find Minimum in Rotated Sorted Array
// Medium
// Topics - Array , Binary Search
// Companies - Facebook
// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.

// O(log(n))tc 
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[r] > nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}