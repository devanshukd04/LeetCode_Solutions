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
        List<List<Integer>> a=new ArrayList<List<Integer>>();
        Queue<TreeNode> b=new LinkedList<TreeNode>();
        b.add(root);
        b.add(null);
        List<Integer> c=new ArrayList<Integer>();
        while(b.peek()!=null){
            List<Integer> d=new ArrayList<Integer>();
            while(b.peek()!=null){
                TreeNode e=b.remove();
                d.add(e.val);
                if(e.left!=null){
                    b.add(e.left);
                }
                if(e.right!=null){
                    b.add(e.right);
                }
            }
            b.remove();
            a.add(d);
            b.add(null);
        }
        for(int i=0;i<a.size();i++){
            if(a.get(i).size()>0){
                int f=a.get(i).size();
                c.add(a.get(i).get(f-1));
            }
        }
        
        System.out.println(a);
        return c;
    }
}