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
    TreeNode b;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode a=new TreeNode(0);
        b=a;
        inOrder(root);
        return a.right;
    }
    public void inOrder(TreeNode root1){
        if(root1==null){
            return;
        }
        inOrder(root1.left);
        root1.left=null;
        b.right=root1;
        b=root1;
        inOrder(root1.right);
    }
}