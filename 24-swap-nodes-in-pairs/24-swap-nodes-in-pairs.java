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
    public ListNode swapPairs(ListNode head) {
        ListNode temp,temp1,temp2,temp3;
        temp=head;
        if(head==null || head.next==null){
            return head;
        }
        head=temp.next;
        temp3=temp.next;
        while(temp!=null && temp.next!=null){
            if(temp.next!=head){
                temp1=temp.next;
                temp3.next=temp1;
                temp2=temp1.next;
                temp1.next=temp;
                temp.next=temp2;
                temp3=temp;
                temp=temp2;
            }
                else{
                temp1=temp.next;
                temp2=temp1.next;
                temp1.next=temp;
                temp.next=temp2;
                temp3=temp;
                temp=temp2;
            }
        }
        return head;
    }
}