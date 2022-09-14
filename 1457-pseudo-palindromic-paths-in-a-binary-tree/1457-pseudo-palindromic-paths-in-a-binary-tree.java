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
    public int pseudoPalindromicPaths (TreeNode root) {
        HashSet<Integer> set=new HashSet<Integer>();
        return helper(root,set);
    }
    public int helper(TreeNode root,HashSet<Integer> set){
        if(root==null){
            if(set.size()==0 || set.size()==1){
                return 1;   
            }
            return 0;
        }
        if(set.contains(root.val)){
            set.remove(root.val);
        }
        else{
            set.add(root.val);
        }
        int left=0;
        int right=0;
        if(root.left==null && root.right==null){
            left=helper(root.left,set);
        }
        if(root.left!=null){
            left=helper(root.left,set);   
        }
        if(root.right!=null){
            right=helper(root.right,set);      
        } 
        if(set.contains(root.val)){
            set.remove(root.val);
        }
        else{
            set.add(root.val);
        }
        return left+right;
    }
}