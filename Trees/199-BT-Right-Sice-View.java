/*
    Binary Tree Right Side View
    Medium
    Topics - Tree , DFS, BFS, BT
    Company Tags- Facebook
    You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of the tree, ordered from top to bottom.
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
// Using BFS- Queue - O(n)tc&sc
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int qLen = que.size();

            for (int i = 0; i < qLen; i++) {
                TreeNode node = que.poll();
                if(i == 0) res.add(node.val);
                if(node.right != null) que.offer(node.right);
                if(node.left != null) que.offer(node.left);
            }
        }
        return res;
    }
}

// Using Recursive DFS - O(n)tc&sc
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode node, int dep, List<Integer> res) {
        if (node == null)
            return;
        if (res.size() == dep)
            res.add(node.val);
        dfs(node.right, dep + 1, res);
        dfs(node.left, dep + 1, res);
    }
}
