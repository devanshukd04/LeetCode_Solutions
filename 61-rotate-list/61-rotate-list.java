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
    public ListNode rotateRight(ListNode head, int k) {
        int a=0;
        int b=0;
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(k==0){
            return head;
        }
        ListNode temp,temp1,temp2;
        temp=head;
        temp1=head;
        while(temp!=null){
            temp1=temp;
            temp=temp.next;
            a+=1;
        }
        k=k%a;
        b=a-k;
        if(b==0 || b==a){
            return head;
        }
        temp=head;
        temp2=head;
        while(b!=0 && temp!=null){
            temp2=temp;
            temp=temp.next;
            b-=1;
        }
        temp2.next=null;
        temp1.next=head;
        return temp;
    }
}