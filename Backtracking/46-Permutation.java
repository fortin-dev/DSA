/*
    Permutations
    Medium
    Topics - Array, Backtracking
    Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.
    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
// Using iteration O(n! * n^2)TC & O(n!*n)SC for Output list.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> new_perms = new ArrayList<>();
            for(List<Integer> p : perms){
                for(int i =0; i <= p.size(); i++){
                    List<Integer> p_copy = new ArrayList<>(p);
                    p_copy.add(i,num);
                    new_perms.add(p_copy);
                }
            }
            perms = new_perms;
        }
        return perms;
    }
}
// Using Backtracking : O(n! *n)TC - Less Optimised due to boolean freq array
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        perm(nums, ds , res , freq);
        return res;
    }
    private void perm(int[] nums, List<Integer> ds, List<List<Integer>> res , boolean[] freq){
        if(ds.size()== nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                perm(nums, ds , res , freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}