/*
    Permutations
    Medium
    Topics - Array, Backtracking
    Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.
    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
// O(n! * n^2)TC & O(n!*n)SC for Output list.
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
