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
    TreeNode root=null;
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int num:preorder){
            insertNode(root,num);
        }
        return root;
    }
    public TreeNode insertNode(TreeNode node,int temp){
        if(root==null){
            TreeNode leaf=new TreeNode(temp);
            leaf.left=null;
            leaf.right=null;
            root=leaf;
            return leaf;
        }
        else if(node==null){
            TreeNode leaf=new TreeNode(temp);
            leaf.left=null;
            leaf.right=null;
            return leaf;
        }
        if(node.val<temp){
            node.right=insertNode(node.right,temp);
        }
        else{
            node.left=insertNode(node.left,temp);
        }
        return node;
    }
}