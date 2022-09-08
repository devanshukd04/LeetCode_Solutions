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
    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            List<Integer> list=new ArrayList<Integer>();
            return list;
        }
        List<Integer> list1=inorderTraversal(root.left);
        list.add(root.val);
        List<Integer> list2=inorderTraversal(root.right);
        return list;
    }
}