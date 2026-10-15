/*
    2913. Subarrays Distinct Element Sum of Squares I
    Easy
    You are given a 0-indexed integer array nums.

    The distinct count of a subarray of nums is defined as:

    Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
    Return the sum of the squares of distinct counts of all subarrays of nums.

    A subarray is a contiguous non-empty sequence of elements within an array.
*/
// Using Hash Set : O(n^2)tc & O(n)sc
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                int d = s.size();
                res += d * d;
            }
        }
        return res;
    }
}

// Optimised solutionn : O(n log n)tc
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long[] cnt = new long[n + 1], tot = new long[n + 1];  // Fenwick trees over previous-copy positions, stored right to left
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;
        for (int r = 0; r < n; r++) {
            int x = nums.get(r), p = last.getOrDefault(x, -1);
            long c = 0, s = 0;
            for (int i = n - p - 1; i > 0; i -= i & -i) {  // boxes 1..n-p-1 hold the positions > p
                c += cnt[i];
                s += tot[i];
            }
            ans += (long) (n - r) * ((long) (r - p) * (r - p) - 2 * (s - p * c));
            for (int i = n - p; i <= n; i += i & -i) {  // insert p; p = -1 lands past the end and is skipped
                cnt[i]++;
                tot[i] += p;
            }
            last.put(x, r);
        }
        return (int) ans;
    }
}