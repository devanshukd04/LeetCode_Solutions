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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode a,b,d,e,temp;
        a=head;
        b=head;
        e=head;
        d=head;
        int c=1;
        int f;
        while(a!=null){
            if(c==k){
                b=a;
            }
            else if(c==k-1){
                d=a;
            }
            a=a.next;
            ++c;
        }
        a=head;
        f=c-1;
        c=c-k-1;
        while(c!=0){
            if(c==1){
                e=a;
            }
            a=a.next;
            --c;
        }
        if(b==a){
            return head;
        }
        else if(b==head && a.next==null && f==2){
            a.next=b;
            b.next=null;
            head=a;
            return head;
        }
        else if(a==head && b.next==null && f==2){
            b.next=a;
            a.next=null;
            head=b;
            return head;
        }
        else if(b==head && a.next==null){
            a.next=b.next;
            e.next=b;
            b.next=null;
            head=a;
            return head;
        }
        else if(a==head && b.next==null){
            b.next=a.next;
            d.next=a;
            a.next=null;
            head=b;
            return head;
        }
        else if(b.next==a){
            d.next=a;
            b.next=a.next;
            a.next=b;
            return head;
        }
        else if(a.next==b){
            e.next=b;
            a.next=b.next;
            b.next=a;
            return head;
        }
        temp=b.next;
        e.next=b;
        b.next=a.next;
        d.next=a;
        a.next=temp;
        return head;
    }
}