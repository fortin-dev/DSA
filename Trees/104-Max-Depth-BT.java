/*
    Maximum Depth of Binary Tree
    Easy
    Topics
    Company Tags
    Given the root of a binary tree, return its depth.
    The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
    Example 1:
    Input: root = [1,2,3,null,null,4]
    Output: 3
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
// Using recursive DFS - O(n)tc & O(h)sc - where n is no.of nodes & his height of tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
