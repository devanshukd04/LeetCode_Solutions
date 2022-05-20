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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return balanced(root);
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
    public boolean balanced(TreeNode root){
        int b,c;
        if(root.left!=null && root.right!=null){
            b=depth(root.left,2);
            c=depth(root.right,2);
            if((b-c)<=1 && (b-c)>=-1){
                return true && balanced(root.left) && balanced(root.right);
            }
            return false;
        }
        else if(root.left!=null){
            b=depth(root.left,2);
            if((b-1)<=1){
                return true && balanced(root.left);
            }
            return false;
        }
        else if(root.right!=null){
            c=depth(root.right,2);
            if((c-1)<=1){
                return true && balanced(root.right);
            }
            return false;
        }
        else{
            return true;
        }
    }
}