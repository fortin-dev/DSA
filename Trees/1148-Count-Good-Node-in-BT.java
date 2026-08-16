/*
    Count Good Nodes in Binary Tree
    Medium
    Topics
    Company Tags
    Hints
    Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x

    Given the root of a binary tree root, return the number of good nodes within the tree.
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
// Using Recursive DFS - O(n)tc & sc
class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int count = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);
        return count;
    }
}

// Using BFS- Queue - O(n)tc & sc
class Solution {
    public int goodNodes(TreeNode root) {
        int count = 0;
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        que.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!que.isEmpty()) {
            Pair<TreeNode, Integer> pair = que.poll();
            TreeNode node = pair.getKey();
            Integer maxVal = pair.getValue();
            if (node.val >= maxVal) {
                count++;
            }
            if (node.left != null) {
                que.offer(new Pair<>(node.left, Math.max(maxVal, node.val)));
            }
            if (node.right != null) {
                que.offer(new Pair<>(node.right, Math.max(maxVal, node.val)));
            }
        }
        return count;
    }
}