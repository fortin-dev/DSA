/*
    322. Coin Change
    Medium
    Topics
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.
*/
// My initial greedy approach : wrong
class Solution {
    // this is a greedy approach and fails becoz :
    // [1,2,3,4,5] and target/ amount is 7, my answer is 3 (5+1+1), but the correct answer if 2(3+4)
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int res = 0;
        int cp = amount;
        Arrays.sort(coins);
        int i = coins.length - 1;

        while (i >= 0 && cp != 0) {
            if (coins[i] <= cp && coins[i] - cp >= 0) {
                cp -= coins[i];
                res++;
                if (cp > coins[i]) {
                    continue;
                } else {
                    i--;
                }
            } else {
                i--;
            }
        }
        if (cp == 0) {
            return res;
        }
        return -1;
    }
}
