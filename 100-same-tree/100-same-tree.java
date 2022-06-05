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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean a,b;
        if(p==null && q==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
        if(p.val==q.val){
            a=isSameTree(p.right,q.right);
            b=isSameTree(p.left,q.left);
            return a&b;
        }
        else{
            return false;
        }
    }
}