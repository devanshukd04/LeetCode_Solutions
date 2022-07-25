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
    public ListNode mergeKLists(ListNode[] lists) {
        int interval=1;
        if(lists.length==0){
            return null;
        }
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i+=interval*2){
                lists[i]=mergeLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
    public ListNode mergeLists(ListNode head1, ListNode head2){
        ListNode head;
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.val<head2.val){
            head=head1;
            head1=head1.next;
        }
        else{
            head=head2;
            head2=head2.next;
        }
        ListNode temp=head;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                temp=head1;
                head1=head1.next;
            }
            else{
                temp.next=head2;
                temp=head2;
                head2=head2.next;
            }
        }
        if(head1!=null){
            temp.next=head1;
        }
        if(head2!=null){
            temp.next=head2;
        }
        return head;
    }
}