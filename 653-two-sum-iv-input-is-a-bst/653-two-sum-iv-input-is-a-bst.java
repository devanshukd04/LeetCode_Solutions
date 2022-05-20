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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> a=new ArrayList<Integer>();
        target(root,a);
        int i=0;
        int c;
        while(i<a.size()){
            c=a.get(i);
            a.remove(i);
            if(a.contains(k-c)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> target(TreeNode root,List<Integer> a){
        if(root==null){
            return a;
        }
        else{
            target(root.left,a);
            a.add(root.val);
            target(root.right,a);
            return a;
        }
        
    }
}