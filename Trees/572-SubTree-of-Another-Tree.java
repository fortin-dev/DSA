/*
    Same Binary Tree
    Easy
    Topics - Tree, Depth-First Search, String Matching, Binary Tree, Hash Function
    Company Tags - Amazon
    Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
    Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
    Example 1:
    Input: p = [1,2,3], q = [1,2,3]
    Output: true
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Using Recursive DFS - O(m*n)tc & O(m+n)sc where m & n are no. of nodes in root & subRoot tree
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null ) return false;
        if(sameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean sameTree(TreeNode r ,TreeNode s){
        if(r == null && s == null) return true;
        if(r != null && s != null && r.val == q.val){
            return sameTree(r.left, s.left) && sameTree(r.right, s.right); 
        }else{
            return false;
        }
    }
}