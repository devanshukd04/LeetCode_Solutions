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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp,temp1;
        temp=head;
        temp1=head;
        boolean stat=false;
        while(temp!=null && head!=null){
            stat=false;
            if(head.val==val){
                head=temp.next;  
                temp=head;
                temp1=temp;
                if(temp!=null){
                    temp=temp.next;
                }
                else{
                    return head;
                }
                if(head==temp1 && temp==null){
                    if(head.val!=val){
                        return temp1;
                    }
                    return temp;
                }
                stat=true;
                temp=temp1;
                
            }
            else if(temp.val==val){
                temp1.next=temp.next;
            }
            else{
                temp1=temp;
            }
            if(temp!=null && stat==false){
                temp=temp.next;
            }
        }
        return head;
    }
}