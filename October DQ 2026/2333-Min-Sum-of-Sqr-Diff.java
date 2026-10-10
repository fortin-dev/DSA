/*
    2333. Minimum Sum of Squared Difference
    Medium
    You are given two positive 0-indexed integer arrays nums1 and nums2, both of length n.

    The sum of squared difference of arrays nums1 and nums2 is defined as the sum of (nums1[i] - nums2[i])2 for each 0 <= i < n.

    You are also given two positive integers k1 and k2. You can modify any of the elements of nums1 by +1 or -1 at most k1 times. Similarly, you can modify any of the elements of nums2 by +1 or -1 at most k2 times.

    Return the minimum sum of squared difference after modifying array nums1 at most k1 times and modifying array nums2 at most k2 times.

    Note: You are allowed to modify the array elements to become negative integers.
*/

// Brute-force - causes TLE
//O((n + k1 + k2) * log n)tc, k is huge
//O(n)sc
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        // Max-heap: top is always the largest diff
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(Math.abs(nums1[i] - nums2[i]));
        }

        long K = (long) k1 + k2;

        while (K > 0 && pq.peek() > 0) {
            int largestDiff = pq.poll();
            pq.offer(largestDiff - 1);
            K--;
        }

        long result = 0;
        while (!pq.isEmpty()) {
            long d = pq.poll();
            result += d * d;
        }

        return result;
    }
}

// Using Counting Sort
//O(n + maxDiff)tc, maxDiff <= 10^5
//O(n)
/class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[n];
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // countDiff[d] = count of indices with diff exactly d
        int[] countDiff = new int[maxDiff + 1];
        for (int d : diff) {
            countDiff[d]++;
        }

        long K = (long) k1 + k2;

        for (int currDiff = maxDiff; currDiff > 0 && K > 0; currDiff--) {
            int countOps = (int) Math.min(countDiff[currDiff], K);

            countDiff[currDiff]-= countOps;
            countDiff[currDiff - 1] += countOps;
            K-= countOps;
        }

        long result = 0;
        for (long d = 1; d <= maxDiff; d++) {
            result += countDiff[(int) d] * d * d;
        }

        return result;
    }
}