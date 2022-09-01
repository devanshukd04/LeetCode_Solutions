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
    public int goodNodes(TreeNode root) {
        return goodNodes(root,Integer.MIN_VALUE);
    }
    public int goodNodes(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int curr=0;
        if(root.val>=max){
            curr=1;
        }
        max=Math.max(root.val,max);
        int left=goodNodes(root.left,max);
        int right=goodNodes(root.right,max);
        return curr+left+right;
    }
}