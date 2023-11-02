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

class Node{
    int sum;
    int count;
    Node(int sum, int count){
        this.sum=sum;
        this.count=count;
    }
}

class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        this.ans=0;
        helper(root);
        return ans;
    }
    
    public Pair<Integer,Integer> helper(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair<Integer,Integer> left=helper(root.left);
        Pair<Integer,Integer> right=helper(root.right);
        
        int avg=(left.getKey()+right.getKey()+root.val)/(left.getValue()+right.getValue()+1);
        
        int nodeSum=left.getKey()+right.getKey()+root.val;
        int nodeCount=left.getValue()+right.getValue()+1;
        
        if(nodeSum/nodeCount==root.val){
            ans++;
        }
        
        return new Pair(nodeSum,nodeCount);
    }
}