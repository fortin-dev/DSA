// rotating arrya 3 times
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int l = 0;
        int r = len-1;
        while(l<r){
            int temp = nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;
            r--;
        }
        l = 0;
        r = k-1;
        while(l<r){
            int temp = nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;
            r--;
        }
        l = k;
        r = len-1;
        while(l<r){
            int temp = nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;
            r--;
        }
    }
}