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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxFreq=helper(root,map);
        
        List<Integer> list=new ArrayList<>();
        
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                list.add(key);
            }
        }
    
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int helper(TreeNode root, Map<Integer,Integer> map){
        if(root==null){
            return 0;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        int leftMaxFreq=helper(root.left,map);
        int rightMaxFreq=helper(root.right,map);
        
        return Math.max(map.get(root.val),Math.max(leftMaxFreq,rightMaxFreq));
    }
}