class Solution {
    public int maximumProduct(int[] nums) {
        int p1=Integer.MIN_VALUE;
        int p2=Integer.MIN_VALUE;
        int p3=Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0 ; i<nums.length ; i++){
            int n = nums[i];
            if(n > p1){
                p3=p2;
                p2=p1;
                p1=n;
            }
            else if( n <= p1 && n>p2){
                p3=p2;
                p2=n;
            }
            else if( n <= p2 && n>p3){
                p3=n;
            }
            if(n<min1){
                min2=min1;
                min1=n;
            }
            else if(n < min2){
                min2=n;
            }
        }
        return Math.max((p1*p2*p3) , (p1*min1*min2));
    }
}