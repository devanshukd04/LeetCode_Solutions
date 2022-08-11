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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterTree(root);
        return diameter;
    }
    public int diameterTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=diameterTree(root.left);
        int right=diameterTree(root.right);
        int height=Math.max(left,right);
        diameter=Math.max(diameter,left+right);
        return height+1;
    }
}