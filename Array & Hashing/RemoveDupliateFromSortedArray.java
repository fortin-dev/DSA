class Solution {
    public int removeDuplicates(int[] nums) {
        int k =1;
        int ex=0;
        int i =1;
        while(i< nums.length){
            if(nums[i]==nums[i-1]){
                i++;
                continue;
            }
            nums[ex+1]=nums[1];
            k++;
        }
        return k;
    }
}

//more optimised
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}