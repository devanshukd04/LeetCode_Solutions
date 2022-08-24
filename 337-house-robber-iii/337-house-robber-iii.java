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
    public int rob(TreeNode root) {
        int[] ans=robAmount(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] robAmount(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] a=robAmount(root.left);
        int[] b=robAmount(root.right);
        int[] c=new int[2];
        c[0]=a[1]+b[1]+root.val;
        c[1]=Math.max(a[0],a[1])+Math.max(b[0],b[1]);
        return c;
    }
    
}