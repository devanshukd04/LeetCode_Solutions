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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int i=1;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
         if(count==1){
            head=null;
            return head;
        }
        count=count-n+1;
        temp=head;
        if(count==1){
            head=head.next;
            return head;
        }
        while(i<count-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;
    
    }
}