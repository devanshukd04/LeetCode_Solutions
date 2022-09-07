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
class Solution {
    public String tree2str(TreeNode root) {
        StringBuffer res=new StringBuffer();
        helper(root,res);
        return res.toString();
    }
    public void helper(TreeNode root, StringBuffer res){
        if(root==null){
            return;
        }
        res.append(root.val+"");
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left==null){
            res.append("()");
        }
        else{
            res.append("(");
            helper(root.left,res);
            res.append(")");
        }
        if(root.right==null){
            return;
        }
        res.append("(");
        helper(root.right,res);
        res.append(")");
    }
}
