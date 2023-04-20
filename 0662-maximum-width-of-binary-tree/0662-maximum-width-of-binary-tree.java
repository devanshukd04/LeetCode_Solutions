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
 class Tree{
     TreeNode root;
     long index;
     Tree(TreeNode root,long index){
         this.root=root;
         this.index=index;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tree> queue=new LinkedList<>();
        queue.add(new Tree(root,1));
        int ans=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            long min=Long.MAX_VALUE;
            long max=Long.MIN_VALUE;
            while(size-->0){
                Tree temp=queue.poll();
                if(temp.root.left!=null){
                    long temp1=temp.index-1;
                    queue.add(new Tree(temp.root.left,temp1*2+1));
                }
                if(temp.root.right!=null){
                    long temp1=temp.index-1;
                    queue.add(new Tree(temp.root.right,temp1*2+2));
                }
                min=Math.min(min,temp.index);
                max=Math.max(max,temp.index);
            }
            if(ans<(int)(max-min+1)){
                ans=(int)(max-min+1);
            }
        }
        return ans;
    }
}