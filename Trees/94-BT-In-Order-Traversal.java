/*
    94. Binary Tree Inorder Traversal
    Easy
    Topics - BT, Tree , DFS, Stack
    Given the root of a binary tree, return the inorder traversal of its nodes' values.
    Example 1:
    Input: root = [1,null,2,3]
    Output: [1,3,2]
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
// Using stack - DFS - O(n)tc &sc
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !(st.isEmpty())){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

// Using Recursion - DFS - O(n)tc & sc
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode node,List<Integer> res ){
        if(node == null) return;
        inorder(node.left ,res);
        res.add(node.val);
        inorder(node.right ,res);
    }
}