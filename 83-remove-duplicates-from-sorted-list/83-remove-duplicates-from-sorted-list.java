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
        ListNode temp,temp1,temp2;
        temp=head;
        if(head==null || head.next==null){
            return head;
        }
        temp1=head.next;
        while(temp1!=null){
            if(temp.val!=temp1.val){
                temp.next=temp1;
                temp=temp1;
                temp1=temp1.next;
            }
            else{
                temp1=temp1.next;
                if(temp1==null){
                    temp.next=temp1;
                }
            }
        }
        return head;
    }
}