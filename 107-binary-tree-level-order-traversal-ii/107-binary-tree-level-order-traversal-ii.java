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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Queue q=new LinkedList<>();
        if(root==null){
            return list;
        }
        q.add(root);
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(root.val);
        list.add(list1);
        if(root.left==null && root.right==null){
            return list;
        }
        q.add(null);
        while(q.peek()!=null){
            List<Integer> list2=new ArrayList<Integer>();
            while(q.peek()!=null){
                TreeNode a=(TreeNode)q.remove();
                if(a.left!=null){
                    q.add(a.left);
                    list2.add(a.left.val);
                }
                if(a.right!=null){
                    q.add(a.right);
                    list2.add(a.right.val);
                }
            }
            q.add(null);
            q.remove();
            if(list2.size()!=0){
                list.add(list2);
            }
        }
        Collections.reverse(list);
        return list;
    }
}