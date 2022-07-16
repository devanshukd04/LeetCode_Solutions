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
    public void reorderList(ListNode head) {
        if(head.next==null || head.next.next==null){
            return;
        }
        ListNode h=head;
        ListNode s,f;
        ListNode mid;
        ListNode temp=h;
        s=h;
        f=h;
        while(f!=null && f.next!=null){
            temp=s;
            s=s.next;
            f=f.next.next;
        }
        if(f!=null){
            mid=s.next;
            s.next=null;
        }
        else{
            mid=s;
            temp.next=null;
        }
        ListNode h1=reverseList(mid);
        temp=h;
        ListNode temp1=h1;
        ListNode temp2,temp3;
        while(temp1!=null){
            temp2=temp.next;
            temp3=temp1.next;
            temp.next=temp1;
            temp1.next=temp2;
            temp=temp2;
            temp1=temp3;
        }
    }
    public ListNode reverseList(ListNode head){
        ListNode temp=head;
        ListNode temp1=head.next;
        head.next=null;
        while(temp1!=null){
            ListNode temp2=temp1.next;
            temp1.next=temp;
            temp=temp1;
            temp1=temp2;
        }
        return temp;
    }
}