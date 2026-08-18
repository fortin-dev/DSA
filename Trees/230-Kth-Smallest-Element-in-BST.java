/*
    Kth Smallest Integer in BST
    Medium
    Company Tags- Amazone
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

    A binary search tree satisfies the following constraints:

    The left subtree of every node contains only nodes with keys less than the node's key.
    The right subtree of every node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees are also binary search trees.
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
// Using iterative DFS - O(n)tc & sc
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur= cur.left;
            }
            cur = stack.pop();
            n++;
            if(n == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}

// Using Recursive DFS - O(n)tc & sc
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }

        dfs(node.left, tmp);
        if (tmp[0] == 0) return;

        tmp[0] -= 1;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }

        dfs(node.right, tmp);
    }
}