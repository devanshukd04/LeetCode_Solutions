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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        return maximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode maximumBinaryTree(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        else if(start==end){
            TreeNode leaf=new TreeNode(nums[start]);
            leaf.left=null;
            leaf.right=null;
            return leaf;
        }
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=max>nums[i]?max:nums[i];
        }
        TreeNode node=new TreeNode(max);
        node.left=maximumBinaryTree(nums,start,map.get(max)-1);
        node.right=maximumBinaryTree(nums,map.get(max)+1,end);
        return node;
    }
}