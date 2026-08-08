/*
Diameter of Binary Tree
Easy
Topics - Tree, DFS, BT
The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.
The length of a path between two nodes in a binary tree is the number of edges between the nodes. Note that the path can not include the same node twice
Given the root of a binary tree root, return the diameter of the tree.
Example 1:
Input: root = [1,null,2,3,4,5]
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

// Using DFS - O(n)tc & O(h)sc - where n & h are no. of nodes and height of the tree respectively
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        int diameter = leftHeight + rightHeight;
        int sub = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(diameter, sub);
    }
    public int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
