/*
    Subsets II
    Medium
    Topics
    Company Tags
    You are given an array nums of integers, which may contain duplicates. Return all possible subsets.
    The solution must not contain duplicate subsets. You may return the solution in any order.
    Example 1:
    Input: nums = [1,2,1]
    Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
*/

// Using Bruteforce:- Set : O(n*2^n)tc & O(2^n)sc 
class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(0, nums, new ArrayList<>());
        return new ArrayList<>(res);
    }
    private void subset(int idx, int[] nums, List<Integer> sset) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(sset));
            return;
        }
        sset.add(nums[idx]);
        subset(idx + 1, nums, sset);
        sset.remove(sset.size() - 1);
        subset(idx + 1, nums, sset);
    }
}
