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

// Using Iteratice DFS - Stack - O(n)tc & O(n)tc
class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode , Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res =0;
        
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            int depth = cur.getValue();
            if(node != null){
                res= Math.max(res,depth);
                stack.push(new Pair<>(node.left, depth+1));
                stack.push(new Pair<>(node.right, depth+1));
            }
        }
        return res;
    }
}
