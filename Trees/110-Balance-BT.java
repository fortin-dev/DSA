/*
    Balanced Binary Tree
    Easy
    Topics - Tree, DFS, BT
    Company Tags - Amazone
    Given a binary tree, return true if it is height-balanced and false otherwise.

    A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
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

// Using recursice dfs - O(n)tc & O(h)sc - n->no.of node & h->height of tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1; 
    }
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{1,0};
        }
        int [] left = dfs(root.left);
        int [] right = dfs(root.right);
        boolean balance = (left[0] == 1 && right[0]==1 && (Math.abs(left[1]-right[1]) <=1));
        int height = 1+Math.max(left[1], right[1]);

        return new int[]{balance? 1:0, height};

    }
}

//