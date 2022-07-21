/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        buildString(s,root);
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }
    public void buildString(StringBuilder s,TreeNode root){
        if(root==null){
            s.append('X');
            s.append(',');
            return;
        }
        s.append(root.val);
        s.append(',');
        buildString(s,root.left);
        buildString(s,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("X")){
            return null;
        }
        return buildTree(data.split(","));   
    }
    public TreeNode buildTree(String arr[]){
        if(arr[index].equals("X")){
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(arr[index]));
        index++;
        node.left=buildTree(arr);
        node.right=buildTree(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));