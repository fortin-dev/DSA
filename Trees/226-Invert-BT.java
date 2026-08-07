/*
    Invert Binary Tree
    Easy
    Topics
    Company Tags
    Hints
    You are given the root of a binary tree root. Invert the binary tree and return its root.

    Example 1:
    Input: root = [1,2,3,4,5,6,7]
    Output: [1,3,2,7,6,5,4]
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

// Using recursive DFS - O(n)tc & O(n)sc for recursive stack
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
// Using BFS- Queue - O(n)tc & O(n)sc
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return root;
    }
}
// Using Iteratice DFS - Stack - O(n)tc & O(n)sc
