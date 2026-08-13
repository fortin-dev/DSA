/*
    Same Binary Tree
    Easy
    Topics - BFS, DFS , Tree , BT
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
// Using Recursive DFS - O(n)tc & O(h)sc where n & h are node & height of tree res.
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
}

// Using Iterative DFS - O(n)tc & O(n)sc
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pS = new Stack<>();
        Stack<TreeNode> qS = new Stack<>();

        pS.push(p);
        qS.push(q);

        while (!qS.isEmpty() && !qS.isEmpty()) {
            TreeNode pNode = pS.pop();
            TreeNode qNode = qS.pop();

            if (pNode == null && qNode == null)
                continue;
            if (pNode == null || qNode == null)
                return false;
            if (pNode.val != qNode.val)
                return false;

            pS.push(pNode.left);
            qS.push(qNode.left);

            pS.push(pNode.right);
            qS.push(qNode.right);
        }
        return true;
    }
}