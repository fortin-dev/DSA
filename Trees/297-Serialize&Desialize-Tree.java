/*
    Serialize and Deserialize Binary Tree
    Hard
    Topics
    Company Tags
    Hints
    Implement an algorithm to serialize and deserialize a binary tree.

    Serialization is the process of converting an in-memory structure into a sequence of bits so that it can be stored or sent across a network to be reconstructed later in another computer environment.

    You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. There is no additional restriction on how your serialization/deserialization algorithm should work.

    Note: The input/output format in the examples is the sam
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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }
    private void dfsSerialize(TreeNode node, List<String> res){
        if(node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals= data.split(",");
        int [] i = {0};
        return dfsDeserialize(vals,i);
    }
    private TreeNode dfsDeserialize(String[] vals, int[]i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(vals,i);
        node.right = dfsDeserialize(vals,i);
        return node;
    }
}