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
    boolean flag1=false;
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        if(!flag1){
            return null;
        }
        return root;
    }
    public boolean helper(TreeNode root){
        boolean flag=false;
        if(root==null){
            return false;
        }
        if(root.val==1){
            flag=true;
            flag1=true;
        }
        if(helper(root.left)){
            flag=true;
            flag1=true;
        }
        else{
            root.left=null;
        }
        if(helper(root.right)){
            flag=true;
            flag1=true;
        }
        else{
            root.right=null;
        }
        return flag;
    }
}