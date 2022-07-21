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
        ListNode temp=head;
        ListNode leftNode=head;
        ListNode rightNode=head;
        ListNode lleft=null;
        ListNode rright,newleft;
        while(left-1>0){
            lleft=leftNode;
            leftNode=leftNode.next;
            left--;
        }
        while(right-1>0){
            rightNode=rightNode.next;
            right--;
        }
        if(leftNode==rightNode){
            return head;
        }
        rright=rightNode.next;
        rightNode.next=null;
        newleft=reverse(leftNode);
        if(lleft==null){
            head=newleft;
            leftNode.next=rright;
            return head;
        }
        lleft.next=newleft;
        leftNode.next=rright;
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode temp1=head.next;
        ListNode temp2;
        temp.next=null;
        while(temp1!=null){
            temp2=temp1.next;
            temp1.next=temp;
            temp=temp1;
            temp1=temp2;
        }
        return temp;
    }
}