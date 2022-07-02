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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        ListNode temp1=head;
        ListNode temp2=head;
        if(head==null || head.next==null){
            return null;
        }
        while(temp2!=null && temp2.next!=null){
            temp=temp1;
            temp1=temp1.next;
            temp2=temp2.next.next;
}
        temp.next=temp1.next;
        return head;
    }
}