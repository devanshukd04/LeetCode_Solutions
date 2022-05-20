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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null && root.val==targetSum){
            return true;
        }
        return sum(root,targetSum,0);
    }
    public boolean sum(TreeNode root,int targetSum,int a){
        if(root==null){
            return false;
        }
        if(a+root.val==targetSum && root.left==null && root.right==null){
            return true;
        }
        else{
            return sum(root.left,targetSum,a+root.val) || sum(root.right,targetSum,a+root.val);
        }
    }
}