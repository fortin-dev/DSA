class Solution {
    public boolean isPalindrome(int x) {
        int xrev = 0;
        int xc = x;
        int temp= 0 ;
        while(xc>0){
            xrev*=10;
            temp= xc % 100;
            xrev+=temp%10;
            xc= xc/10;
        }
        if(xrev == x){
            return true;
        }
        else{
            return false;
        }
    }
}