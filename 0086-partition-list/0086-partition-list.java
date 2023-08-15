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
    public ListNode partition(ListNode head, int x) {
        ListNode newHead=null;
        ListNode beforePivot=null;
        ListNode afterPivot=null;
        ListNode afterPivotHead=null;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                if(beforePivot==null){
                    newHead=temp;
                    beforePivot=temp;
                }
                else{
                    beforePivot.next=temp;
                    beforePivot=beforePivot.next;
                }
            }
            else{
                if(afterPivot==null){
                    afterPivot=temp;
                    afterPivotHead=temp;
                }
                else{
                    afterPivot.next=temp;
                    afterPivot=afterPivot.next;
                }
            }
            temp=temp.next;
        }
        if(newHead==null){
            return head;
        }
        if(afterPivot!=null){
            afterPivot.next=null;
        }
        beforePivot.next=afterPivotHead;
        return newHead;
    }
}