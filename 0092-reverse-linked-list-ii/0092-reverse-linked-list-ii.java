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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preStart=null;
        ListNode start=null;
        ListNode end=null;
        ListNode postEnd=null;
        ListNode temp=head;
        int pos=1;
        
        while(temp!=null){
            if(pos==left-1){
                preStart=temp;
            }
            if(pos==left){
                start=temp;
            }
            if(pos==right){
                end=temp;
            }
            if(pos==right+1){
            postEnd=temp;
            }
            temp=temp.next;
            pos++;    
        }
        end.next=null;
        ListNode reversePart=reverse(start);
         temp=reversePart;
        while(temp!=null){
            temp=temp.next;
        }
        if(preStart!=null){
            preStart.next=reversePart;
        }
        else{
            preStart=reversePart;
            head=reversePart;
        }
        temp=preStart;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=postEnd;
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode next=head;
        ListNode temp=head;
        while(temp!=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}