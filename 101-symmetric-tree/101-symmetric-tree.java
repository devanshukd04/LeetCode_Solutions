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
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        return symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode root,TreeNode root1){
        if(root==null && root1==null){
            return true;
        }
        if(root==null || root1==null){
            System.out.println(root+" "+root1);
            return false;
        }
        if(root.val==root1.val){
            return true && symmetric(root.left,root1.right) && symmetric(root.right,root1.left);
        }
        else{
            return false;
        }
    }
}