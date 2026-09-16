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
// Using Backtracking with extra space : O(n*2^n)tc & O(n)+O(2^n)sc
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, subset, nums);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, subset, nums);
    }
}

