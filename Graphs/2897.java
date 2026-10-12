/*
    2897. Apply Operations on Array to Maximize Sum of Squares
    Hard
    You are given a 0-indexed integer array nums and a positive integer k.

    You can do the following operation on the array any number of times:

    Choose any two distinct indices i and j and simultaneously update the values of nums[i] to (nums[i] AND nums[j]) and nums[j] to (nums[i] OR nums[j]). Here, OR denotes the bitwise OR operation, and AND denotes the bitwise AND operation.
    You have to choose k elements from the final array and calculate the sum of their squares.
    Return the maximum sum of squares you can achieve.
    Since the answer can be very large, return it modulo 109 + 7.
*/
//Bits Observation + Greedy Approach
//O(n+k)tc & O(1)sc

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        final int BITS = 30;                  // nums[i] <= 10^9 < 2^30

        // count[b] = number of 1s in bit column b
        int[] count = new int[BITS];

        for (int num : nums) {
            for (int b = 0; b < BITS; b++) {
                if ((num & (1 << b)) != 0) {
                    count[b]++;               // found a '1' in bit position b
                }
            }
        }

        long result = 0;

        while (k-- > 0) {
            long curr = 0;

            for (int b = 0; b < BITS; b++) {
                if (count[b] > 0) {
                    count[b]--;
                    curr |= (1L << b);        // 1L so it is a long, not an int
                }
            }

            result = (result + curr * curr) % MOD;
        }

        return (int) result;
    }
}