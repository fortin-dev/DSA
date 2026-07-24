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
//wrapped into a single funtion
class Solution {
    public void rev(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
    }
}