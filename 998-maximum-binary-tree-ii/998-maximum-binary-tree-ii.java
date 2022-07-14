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
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    List<Integer> list=new ArrayList<Integer>();
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        inorder(root);
        list.add(val);
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }
        return maximumBinaryTree(list,0,list.size()-1);
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode maximumBinaryTree(List<Integer> nums,int start,int end){
        if(start>end){
            return null;
        }
        else if(start==end){
            TreeNode leaf=new TreeNode(list.get(start));
            leaf.left=null;
            leaf.right=null;
            return leaf;
        }
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=max>list.get(i)?max:list.get(i);
        }
        TreeNode node=new TreeNode(max);
        node.left=maximumBinaryTree(nums,start,map.get(max)-1);
        node.right=maximumBinaryTree(nums,map.get(max)+1,end);
        return node;
    }
}