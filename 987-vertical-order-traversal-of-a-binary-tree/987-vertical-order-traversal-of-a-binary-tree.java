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
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    int maxlevel=Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<List<Integer>,List<Integer>> map=new HashMap<List<Integer>,List<Integer>>();
        helper(root,0,map,0);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for(int j=min;j<=max;j++){
            List<Integer> list=new ArrayList<Integer>();
            List<Integer> key=new ArrayList<Integer>();
            for(int i=0;i<=maxlevel;i++){
                key.add(i);
                key.add(j);
                if(map.containsKey(key)){
                    Collections.sort(map.get(key));
                    list.addAll(map.get(key));
                }
                key.remove(1);
                key.remove(0);
            }
            res.add(list);
        }
        
        return res;
    }
    public void helper(TreeNode root,int col,HashMap<List<Integer>,List<Integer>> map,int level){
        if(root==null){
            return;
        }
        min=Math.min(min,col);
        max=Math.max(max,col);
        maxlevel=Math.max(maxlevel,level);
        List<Integer> key=new ArrayList<Integer>();
        key.add(level);
        key.add(col);
        if(map.containsKey(key)){
            List<Integer> list=map.get(key);
            list.add(root.val);
        }
        else{
            List<Integer> list=new ArrayList<Integer>();
            list.add(root.val);
            map.put(key,list);
        }
        helper(root.left,col-1,map,level+1);
        helper(root.right,col+1,map,level+1);
    }
}