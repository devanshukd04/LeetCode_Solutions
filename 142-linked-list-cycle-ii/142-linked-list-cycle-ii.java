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
    public ListNode detectCycle(ListNode head) {
        ListNode temp,temp1;
        temp=head;
        temp1=head;
        boolean stat=true;
        while(temp1!=null && temp1.next!=null){
            temp=temp.next;
            temp1=temp1.next.next;
            if(temp==temp1){
                stat=false;
                break;
            }
        }
        if(stat){
            return null; 
        }
        temp1=head;
        while(temp!=temp1){
            temp1=temp1.next;
            temp=temp.next;
        }
        return temp;
    }
}