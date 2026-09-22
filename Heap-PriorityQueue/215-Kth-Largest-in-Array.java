/*
    Kth Largest Element in an Array
    Medium
    Topics
    Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
    By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
    Follow-up: Can you solve it without sorting?
    Example 1:
    Input: nums = [2,3,1,5,4], k = 2
    Output: 4
*/
//Using simple sorting : O(n log n)tc
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// Using min heap : we maintain only the k size of heap : this way the kth largest element remains at top of heap : O(n log k)tc

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}