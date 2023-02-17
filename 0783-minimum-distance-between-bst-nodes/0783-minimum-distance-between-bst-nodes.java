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
    public int minDiffInBST(TreeNode root) {
        List<Integer> ans=new ArrayList<Integer>();
        int min=Integer.MAX_VALUE;
        inorder(root,ans);
        for(int i=0;i<ans.size()-1;i++){
            min=Math.min(min,ans.get(i+1)-ans.get(i));
        }
        return min;
    }
    public void inorder(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}