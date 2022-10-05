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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        helper(root,val,depth,1);
        return root;
    }
    public void helper(TreeNode root,int val,int depth,int currdepth){
        if(root==null){
            return;
        }
        if(depth==currdepth+1){
            TreeNode nodeleft=new TreeNode(val);
            TreeNode noderight=new TreeNode(val);
            nodeleft.left=root.left;
            root.left=nodeleft;
            noderight.right=root.right;
            root.right=noderight;
            return;
        }
        helper(root.left,val,depth,currdepth+1);
        helper(root.right,val,depth,currdepth+1);
    }
}