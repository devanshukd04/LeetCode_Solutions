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
class BSTIterator {
    List<Integer> a;
    int i;
    public BSTIterator(TreeNode root) {
        a=new ArrayList<Integer>();
        i=0;
        inOrder(root);
    }
    public void inOrder(TreeNode root1){
        if(root1==null){
            return;
        }
        inOrder(root1.left);
        a.add(root1.val);
        inOrder(root1.right);
    }
    public int next() {
        return a.get(i++);
    }
    
    public boolean hasNext() {
        if(i<=a.size()-1){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */