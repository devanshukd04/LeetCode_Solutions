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
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(0);
        ListNode temp=head1;
        temp.next=null;
        ListNode head2=new ListNode(1);
        ListNode temp1=head2;
        temp1.next=null;
        ListNode temp2=head;
        while(temp2!=null){
            if(temp2.val<x){
                temp.next=temp2;
                temp=temp.next;
            }
            else{
                temp1.next=temp2;
                temp1=temp1.next;
            }
            temp2=temp2.next;
        }
        temp.next=head2.next;
        temp1.next=null;
        return head1.next;
    }
}