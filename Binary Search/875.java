// Using Binary Search O(log(m)*n) where m is max pile and n is length of piles array
// Koko Eating Bananas
// Medium
// Topics - Array , Binary Search
// Company Tags - Google
// You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.

// You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.

// Return the minimum integer k such that you can eat all the bananas within h hours.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l<=r){
            int k = (l+r)/2;
            long time = 0;
            for(int p : piles){
                time+= Math.ceil((double) p/k);
            }
            if(time <= h){
                res = k;
                r = k-1;
            }
            else{
                l= k+1;
            }
        }
        return res;
    }
}
