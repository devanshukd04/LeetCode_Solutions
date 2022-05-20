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
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validBST(TreeNode root,long a,long b){
        if(root==null){
            return true;
        }
        if(root.val>a && root.val<b){
            return validBST(root.left,a,root.val) && validBST(root.right,root.val,b);
        }
        else{
            return false;
        }
    }
}