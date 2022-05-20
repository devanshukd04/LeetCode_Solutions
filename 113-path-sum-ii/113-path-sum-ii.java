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
    List<List<Integer>> list =new ArrayList<List<Integer>>(); 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list1=new ArrayList<Integer>();
        sum(root,targetSum,0,list1);
        return list;
    }
    public void sum(TreeNode root,int targetSum,int a,List<Integer> list1){
        if(root==null){
            return;
        }
        list1.add(root.val);
        if(a+root.val==targetSum && root.left==null && root.right==null){
            List<Integer> list2=new ArrayList<Integer>();
            list2.addAll(list1);
            list.add(list2);
            list1.remove(list1.size()-1);
            return;
        }
        else{
            sum(root.left,targetSum,a+root.val,list1);
            sum(root.right,targetSum,a+root.val,list1);
            list1.remove(list1.size()-1);
            return;
        }
    }
}