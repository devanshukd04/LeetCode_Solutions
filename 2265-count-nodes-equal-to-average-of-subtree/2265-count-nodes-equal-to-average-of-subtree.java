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
    
    public Node helper(TreeNode root){
        if(root==null){
            return new Node(0,0);
        }
        Node left=helper(root.left);
        Node right=helper(root.right);
        
        int avg=(left.sum+right.sum+root.val)/(left.count+right.count+1);
        
        if(avg==root.val){
            ans++;
        }
        left.sum+=right.sum+root.val;
        left.count+=right.count+1;
        return left;
    }
}