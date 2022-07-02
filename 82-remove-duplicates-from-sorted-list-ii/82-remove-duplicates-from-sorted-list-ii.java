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
    public ListNode deleteDuplicates(ListNode head) {        
        ListNode temp=new ListNode(0,head);
        ListNode temp1=temp;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                temp1.next=head.next;
            }
            else{
                temp1=temp1.next;
            }
            head=head.next;
        }
        
        return temp.next; 
    }
}