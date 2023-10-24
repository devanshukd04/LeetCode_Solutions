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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty() && queue.peek()!=null){
            int levelMax=Integer.MIN_VALUE;
            while(queue.peek()!=null){
                TreeNode node=queue.poll();
                levelMax=Math.max(levelMax,node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(levelMax);
            queue.poll();
            queue.add(null);
        }
        return ans;
    }
}