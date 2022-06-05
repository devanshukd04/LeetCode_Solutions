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
    int count=0;
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> a=new ArrayList<List<String>>();
        int b=height(root,0);
        int c=(int)Math.pow(2,b+1)-1;
        for(int i=0;i<=b;i++){
            List<String> a2=new ArrayList<String>();
            for(int j=0;j<c;j++){
                a2.add("");
            }
            a.add(a2);
        }
        listTree(a,0,c/2,root,true,b);
        return a;
    }
    public int height(TreeNode root1,int count){
        int a1,b1;
        if(root1==null){
            return -1;
        }
        else{
            a1=height(root1.left,count);
            b1=height(root1.right,count);
            int c=Math.max(a1,b1)+1;
            return c;
        }
    }
    public void listTree(List<List<String>> a,int r, int c,TreeNode b, boolean flag,int height){
        if(b==null){
            return;
        }
        if(count==0){
            List<String> a2=a.get(r);
            a2.set(c,b.val+"");
            ++count;
            listTree(a,r,c,b.right,false,height);
            listTree(a,r,c,b.left,true,height);
            
        }
        else{
            if(flag){
                int row=r+1;
                int column=c-(int)Math.pow(2,height-r-1);   
                List<String> a2=a.get(row);
                a2.set(column,b.val+"");
                listTree(a,row,column,b.right,false,height);
                listTree(a,row,column,b.left,true,height);
            }
            else{
                int row=r+1;
                int column=c+(int)Math.pow(2,height-r-1);   
                List<String> a2=a.get(row);
                a2.set(column,b.val+"");
                listTree(a,row,column,b.right,false,height);
                listTree(a,row,column,b.left,true,height);
            }
            return;
        }
    }
}