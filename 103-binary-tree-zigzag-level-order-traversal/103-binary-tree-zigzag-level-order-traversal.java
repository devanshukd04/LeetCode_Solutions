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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> a=new ArrayList<Integer>();
        List<List<Integer>> c=new ArrayList<List<Integer>>();
        Queue<TreeNode> b=new LinkedList<>(); 
        boolean stat=false;
        if(root==null){
            return c;
        }
        a.add(root.val);
        c.add(a);
        b.add(root);
        b.add(null);
        while(!b.isEmpty()){
            List<Integer> d=new ArrayList<Integer>();
            while(b.peek()!=null){
                TreeNode q=b.remove();
                if(q.left!=null){
                    b.add(q.left);
                    d.add(q.left.val);
                }
                if(q.right!=null){
                    b.add(q.right);
                    d.add(q.right.val);
                }   
            }
            if(!stat){
                Collections.reverse(d);
            }
            if(d.size()>0){
                c.add(d);
            }
            b.remove();
            if(!b.isEmpty()){
                b.add(null);
            }
            stat=!stat;
        }
        return c;
    }
}