/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode a=head;
        List<Integer> b=new ArrayList<Integer>();
        while(a!=null){
            b.add(a.val);
            a=a.next;
        }
        return BST(b,0,b.size()-1);
    }
    public TreeNode BST(List<Integer> a, int i, int j){
        if(i>j || i<0 || j>a.size()-1){
            return null;
        }
        int mid=(i+j)/2;
        TreeNode b=new TreeNode(a.get(mid));
        b.left=BST(a,i,mid-1);
        b.right=BST(a,mid+1,j);
        return b;
    }
}