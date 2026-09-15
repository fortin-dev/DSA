/*
    39. Combination Sum
    Medium
    Topics- Array, Backtracking
    Companies - Amazon
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
    Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.
    Example 2:
*/

// Using Decision Tree/Backtracking - O(2^t/m)tc & O(t/m)sc
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, new ArrayList<>(), 0 , candidates, target);
        return res;
    }
    private void dfs(int i , List<Integer> cur , int total, int[] nums, int target){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i; j < nums.length; j++){
            if(total + nums[j] > target) return;

            cur.add(nums[j]);
            dfs(j, cur, total+nums[j], nums, target);
            cur.remove(cur.size()-1);
        }
    }
}