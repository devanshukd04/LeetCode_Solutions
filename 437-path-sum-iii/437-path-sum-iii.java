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
    int ans=0;
    HashSet<TreeNode> set=new HashSet<TreeNode>();
    public int pathSum(TreeNode root, int targetSum) {
        sum(root,0,targetSum);
        return ans;
    }
    public void sum(TreeNode root,long currsum,int targetsum){
        if(root==null){
            return;
        }
        currsum=currsum+root.val;
        if(currsum==targetsum){
            ++ans;
        }
        sum(root.right,currsum,targetsum);
        sum(root.left,currsum,targetsum);
        if(!set.contains(root)){
            set.add(root);
            sum(root.right,0,targetsum);
            sum(root.left,0,targetsum);
        }
    }
}