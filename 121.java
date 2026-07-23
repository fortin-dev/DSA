// brute-force O(n^2)tc
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i<prices.length-1 ; i++){
            for(int j = i+1; j<prices.length ; j++){
                int cpr = prices[j]-prices[i];
                max = Math.max(max, cpr);
            }
        }
        return max;
    }
}

//using two-pointer - O(n)tc
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;
        int r = 1;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                max = Math.max(max, prices[r]-prices[l]);
            }
            else{
                l=r;
            }
            r++;
        }
        return max;
    }
}
// dynamic-programming approach O(n)tc
class Solution {
    public int maxProfit(int[] prices) {
        int minB = prices[0];
        int maxP = 0;
        for(int sell : prices){
            maxP = Math.max(maxP, sell - minB);
            minB = Math.min(minB ,sell );
        }
        return maxP;
    }
}
