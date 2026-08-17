/*
    98. Validate Binary Search Tree
    Medium
    Topics - Tree, BST, DFS, BFS
    premium lock icon
    Companies
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys strictly less than the node's key.
    The right subtree of a node contains only nodes with keys strictly greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
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

// Using Recusive DFS - O(n)tc & sc
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean valid(TreeNode node, long left , long right){
        if(node == null){
            return true;
        }
        if(!(left < node.val && node.val < right)){
            return false;
        }
        return valid(node.left , left , node.val) && valid(node.right , node.val , right);
    }
}

// Using Queue - BFS - O(n)tc & sc
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<Object[]> que = new LinkedList<>();
        que.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});

        while(! que.isEmpty()){
            Object[] cur = que.poll();
            TreeNode node = (TreeNode) cur[0];
            long left = (long) cur[1];
            long right = (long) cur[2];

            if(!(left < node.val && node.val < right)){
                return false;
            }
            if(node.left != null){
                que.offer(new Object[]{node.left , left , (long)node.val});
            }
            if(node.right != null){
                que.offer(new Object[]{node.right , (long)node.val, right});
            }
        }
        return true;
    }
}

// Using iterative DFS - Stack - IN-ORDER TRAVERSAL - O(n)tc & sc
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre= null;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(pre!=null && root.val <= pre.val) return false;
            pre = root;
            root= root.right;
        }
        return true;
    }
}