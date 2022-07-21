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
    TreeNode ans=null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deepestLeaves(root,depthTree(root));
        return ans;
    }
    public int depthTree(TreeNode root){
        if(root==null){
            return -1;
        }
        int left=depthTree(root.left);
        int right=depthTree(root.right);
        return Math.max(left,right)+1;
    }
    public boolean deepestLeaves(TreeNode root,int depth){
        if(root==null){
            if(depth==-1){
                return true;
            }
            else{
                return false;
            }
        }
        boolean left=deepestLeaves(root.left,depth-1);
        boolean right=deepestLeaves(root.right,depth-1);
        if(left==true && right==true){
            ans=root;
            return true;
        }
        if(left==true || right==true){
            return true;
        }
        return false;
    }
}