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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return depth(root,1);
    }
    public int depth(TreeNode root,int a){
        int b,c;
        if(root.left!=null && root.right!=null){
            b=depth(root.left,a+1);
            c=depth(root.right,a+1);
            if(b>c){
                return b;
            }
            return c;
        }
        else if(root.left!=null){
            b=depth(root.left,a+1);
            if(b>a){
                return b;
            }
            return a;
        }
        else if(root.right!=null){
            c=depth(root.right,a+1);
            if(c>a){
                return c;
            }
            return a;
        }
        else{
            return a;
        }
    }
}