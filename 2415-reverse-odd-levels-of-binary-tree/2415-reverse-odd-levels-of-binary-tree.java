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
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left,root.right,0);
        return root;
    }
    public void helper(TreeNode root1,TreeNode root2,int level){
        if(root1==null || root2==null){
            return;
        }
        if(level%2==0){
            int val=root1.val;
            root1.val=root2.val;
            root2.val=val;
        }
        helper(root1.left,root2.right,level+1);
        helper(root1.right,root2.left,level+1);
    }
}