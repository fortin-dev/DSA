//best approach
class Solution {
    public int maxProduct(int n) {
        int p1=0,p2=0;
        while(n>0){
            int last = n%10;
            if(last > p1){
                p2=p1;
                p1=last;
            }
            else if(last>p2){
                p2=last;
            }
            n=n/10;
        }
        return p1*p2;
    }
}