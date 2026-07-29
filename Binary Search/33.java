// 33. Search in Rotated Sorted Array
// Medium
// Topics - Arrays, Binary Search
// Companies - Google

// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// using Binary Search - O(log(n))tc
class Solution {
    public int search(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target ) return mid;
            if(nums[l] == target ) return l;
            if(nums[r] == target ) return r;

            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid] ){
                    r = mid-1;
                }
                else{
                    l= mid+1;
                }
            }else{
                if(target <=nums[r] && nums[mid] < target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
