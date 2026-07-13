class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int k = j;

        int[] res = new int[nums.length];
        while(i<j){
            int isqr = nums[i]*nums[i];
            int jsqr = nums[j]*nums[j];

            if(isqr> jsqr){
                res[k--]= isqr;
                i++;
            }
            else{
                res[k--]= jsqr;
                j--;
            }
        }
        res[0] = nums[i] * nums[i];
        return res;
    }
}