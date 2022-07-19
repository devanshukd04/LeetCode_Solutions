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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> b=new LinkedList<TreeNode>();
        b.add(root);
        b.add(null);
        List<Integer> c=new ArrayList<Integer>();
        while(b.peek()!=null){
            TreeNode node=null;
            while(b.peek()!=null){
                node=b.remove();
                if(node.left!=null){
                    b.add(node.left);
                }
                if(node.right!=null){
                    b.add(node.right);
                }
            }
            c.add(node.val);   
            b.remove();
            b.add(null);
        }
        return c;
    }
}