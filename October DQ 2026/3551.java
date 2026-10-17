/*
    3551. Minimum Swaps to Sort by Digit Sum
    Medium
    You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number. If two numbers have the same digit sum, the smaller number appears first in the sorted order.

    Return the minimum number of swaps required to rearrange nums into this sorted order.

    A swap is defined as exchanging the values at two distinct positions in the array.
*/
//Approach (Sort and Compare Indices and Swap)
//T.C : O(nlogn * N), N = log10(Max Number) to find digits
//S.C : O(n)
class Solution {

    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    private int compareByDigitSum(int num1, int num2) {
        int num1DigitSum = getDigitSum(num1);
        int num2DigitSum = getDigitSum(num2);

        if (num1DigitSum != num2DigitSum) {
            return Integer.compare(num1DigitSum, num2DigitSum);
        }

        return Integer.compare(num1, num2);
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] afterSorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            afterSorted[i] = nums[i];
        }

        Arrays.sort(afterSorted, this::compareByDigitSum);

        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIdx.put(nums[i], i);
        }

        int swapCount = 0;
        for (int i = 0; i < n; i++) {
            int expectedVal = afterSorted[i];
            int currVal = nums[i];

            if (expectedVal == currVal) continue;

            int idx = valToIdx.get(expectedVal);

            nums[i] = expectedVal;
            nums[idx] = currVal;

            valToIdx.put(expectedVal, i);
            valToIdx.put(currVal, idx);

            swapCount++;
        }

        return swapCount;
    }
}