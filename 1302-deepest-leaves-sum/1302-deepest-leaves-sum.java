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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> a=new LinkedList<TreeNode>();
        TreeNode b;
        a.add(root);
        a.add(null);
        int value=0;
        while(a.peek()!=null){
            value=0;
            while(a.peek()!=null){
                b=a.poll();
                value+=b.val;
                if(b.left!=null){
                    a.add(b.left);
                }
                if(b.right!=null){
                    a.add(b.right);
                }
            }
            a.poll();
            a.add(null);
        }
        return value;
    }
}