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

