class Solution {
    public int maxProduct(int[] nums) {
        int p1=0;
        int p2=0;
        for(int n : nums){
            n=n-1;
            if(n > p1){
                p2=p1;
                p1=n;
            }
            else if(n > p2){
                p2=n;
            }
        }
        return (p1*p2);
    }
}