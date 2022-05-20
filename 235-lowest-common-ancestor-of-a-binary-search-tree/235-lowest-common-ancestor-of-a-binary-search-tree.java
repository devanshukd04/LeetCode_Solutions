/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonAncestor(root,p,q);
    }
    public TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
        TreeNode leftlca;
        TreeNode rightlca;
        if(root==null){
            return null;
        }
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        if(root.val>p.val && root.val>q.val){
            leftlca=commonAncestor(root.left,p,q);
            rightlca=null;
        }
        else if(root.val<p.val && root.val<q.val){
            rightlca=commonAncestor(root.right,p,q);
            leftlca=null;
        }
        else{
            leftlca=commonAncestor(root.left,p,q);
            rightlca=commonAncestor(root.right,p,q);
        }
        if(leftlca!=null && rightlca!=null){
            return root;
        }
        if(rightlca==null){
            return leftlca;
        }
        return rightlca;
    }
}