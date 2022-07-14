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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildInorder(preorder,inorder,0);
    }
    public TreeNode buildInorder(int[] preorder, int[] inorder, int parent){
        int count=0;
        if(inorder.length==0){
            return null;
        }
        else if(inorder.length==1){
            TreeNode a=new TreeNode(inorder[0]);
            a.left=null;
            a.right=null;
            return a;
        }
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int b=0;
        for(int i=parent;i<preorder.length;i++){
            if(map.containsKey(preorder[i])){
                b=i;
                count=map.get(preorder[i]);
                break;
            }
        }
        int[] left=new int[count];
        int[] right=new int[inorder.length-count-1];
        map.clear();
        for(int i=0;i<count;i++){
            left[i]=inorder[i];
        }
        for(int i=count+1;i<inorder.length;i++){
            right[i-count-1]=inorder[i];
        }
        TreeNode node=new TreeNode(inorder[count]);
        node.left=buildInorder(preorder,left,b+1);
        node.right=buildInorder(preorder,right,b+1);
        return node;
    }
}