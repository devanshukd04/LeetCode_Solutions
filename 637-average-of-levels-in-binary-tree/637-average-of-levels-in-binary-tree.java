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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<Double>();
        Queue q=new LinkedList<>();
        if(root==null){
            return list;
        }
        q.add(root);
        q.add(null);
        while(q.peek()!=null){
            double sum=0;
            int count=0;
            while(q.peek()!=null){
                TreeNode a=(TreeNode)q.remove();
                sum+=a.val;
                count++;
                if(a.left!=null){
                    q.add(a.left);
                }
                if(a.right!=null){
                    q.add(a.right);
                }
            }
            q.add(null);
            q.remove();
            list.add(sum/count);
        }
        return list;
    }
}