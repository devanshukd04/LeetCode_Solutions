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
    public ListNode reverseList(ListNode head) {
        ListNode temp,temp1,temp2;
        temp=head;
        if(head==null || head.next==null){
            return head;
        }
        temp1=head.next;
        head.next=null;
        while(temp1.next!=null){
            temp2=temp1.next;
            temp1.next=temp;
            temp=temp1;
            temp1=temp2;
        }
        temp1.next=temp;
        return temp1;
    }
}