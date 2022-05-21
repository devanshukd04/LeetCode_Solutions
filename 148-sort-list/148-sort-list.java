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
    public ListNode sortList(ListNode head) {
        ListNode temp;
        temp=mergeSort(head);
        return temp;
    }
    public ListNode mergeSort(ListNode temp){
        if(temp==null || temp.next==null){
            return temp;
        }
        ListNode temp1,temp2,temp3,temp4,temp5,head;
        temp1=temp;
        temp2=temp;
        temp3=temp;
        while(temp2!=null && temp2.next!=null){
            temp3=temp1;
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        temp3.next=null;
        temp4=mergeSort(temp);
        temp5=mergeSort(temp1);
        if(temp4.val>temp5.val){
            head=temp5;
            temp5=temp5.next;
        }
        else{
            head=temp4;
            temp4=temp4.next;
        }
        temp3=head;
        while(temp4!=null && temp5!=null){
            if(temp4.val>temp5.val){
                temp3.next=temp5;
                temp3=temp3.next;
                temp5=temp5.next;
            }
            else{
                temp3.next=temp4;
                temp3=temp3.next;
                temp4=temp4.next;
            }
        }
        while(temp4!=null){
            temp3.next=temp4;
            temp3=temp3.next;
            temp4=temp4.next;
        }
        while(temp5!=null){
            temp3.next=temp5;
            temp3=temp3.next;
            temp5=temp5.next;
        }
        return head;
    }
}