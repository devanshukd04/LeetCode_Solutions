/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp,temp1;
        temp=head;
        temp1=head;
        while(temp1!=null && temp1.next!=null){
            temp=temp.next;
            temp1=temp1.next.next;
            if(temp==temp1){
                return true;
            }
        }
        return false;
        
    }
}