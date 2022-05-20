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
    int i=0;
    public int kthSmallest(TreeNode root, int k) {
        int a;
        if(root==null){
            return 0;
        }
        else{
            a=kthSmallest(root.left,k);
            if(a!=0){
                return a;
            }
            i++;
            if(i==k){
                return root.val;
            }
            a=kthSmallest(root.right,k);
            if(a!=0){
                return a;
            }
            return a;
        }
    }
}