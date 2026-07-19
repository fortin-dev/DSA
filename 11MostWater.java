class Solution {
    public int maxArea(int[] height) {
        int maximum = 0 ;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            int currMax;
            if(height[i]>=height[j]){
                currMax = height[j]*(j-i);
                j--;
            }
            else{
                currMax = height[i]*(j-i);
                i++;
            }
            maximum=Math.max(currMax, maximum);
        }
        return maximum;
    }
}