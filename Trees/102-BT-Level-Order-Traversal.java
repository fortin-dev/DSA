/*
    102. Binary Tree Level Order Traversal
    Medium
    Topics - Tree ,BFS , BT
    Companies - Facebook
    Hint
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]
    Example 2:
    Input: root = [1]
    Output: [[1]]
    Example 3:
    Input: root = []
    Output: []
*/
//   Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//Using BFS(Queue) - O(n)tc & sc
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for(int i = que.size(); i>0 ;i--){
                TreeNode cur = que.poll();
                if(cur != null){
                    level.add(cur.val);
                    que.add(cur.left);
                    que.add(cur.right);
                }
            }
            if(level.size() >0){
                res.add(level);
            }
        }
        return res;
    }
}

// Using Recursice DFS - O(n)tc & sc
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    private void dfs(TreeNode node, int depth, List<List<Integer>> res){
        if(node == null){
            return;
        }
        if(res.size() == depth){
            res.add(new ArrayList<>());
        }

        res.get(depth).add(node.val);
        dfs(node.left, depth+1 , res);
        dfs(node.right, depth+1, res);
    }
}
