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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd;
        ListNode even;
        ListNode even_head;
        if(head==null){
            return null;
        }
        odd=head;
        even=head.next;
        even_head=even;
        while(even!=null && even.next!=null){
            
            ListNode odd_temp=even.next;
            ListNode even_temp=odd_temp.next;
            
            odd.next=odd_temp;
            odd=odd_temp;
            even.next=even_temp;
            even=even_temp;
            
        }
        odd.next=even_head;
        if(even!=null){
            even.next=null;
        }
        return head;
    }
}