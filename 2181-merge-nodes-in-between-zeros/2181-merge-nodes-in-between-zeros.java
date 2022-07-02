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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp,temp1;
        boolean stat=true;
        temp=head.next;
        temp1=head;
        while(temp!=null){
            if(temp.val==0){
                temp1.next=temp;
                stat=true;
            }
            if(temp.val!=0 && stat){
                temp1=temp;
                stat=false;
            }
            else if(temp.val!=0){
                temp1.val+=temp.val;
            }
            temp=temp.next;
        }
        temp=head.next;
        head=temp;
        while(temp!=null){
            temp.next=temp.next.next;
            temp=temp.next;
            
        }
        return head;
    }
}