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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newhead=reverse(slow);
        ListNode orighead=head;
        while(orighead!=null && newhead!=null){
            if(orighead.val!=newhead.val){
                return false;
            }
            orighead=orighead.next;
            newhead=newhead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode  head){
        ListNode temp=head;
        ListNode temp1=head.next;
        temp.next=null;
        while(temp1!=null){
            ListNode temp2=temp1.next;
            temp1.next=temp;
            temp=temp1;
            temp1=temp2;
        }
        return temp;
    }
}