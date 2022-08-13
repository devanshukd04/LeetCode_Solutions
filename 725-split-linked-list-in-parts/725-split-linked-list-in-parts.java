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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
        int extra=size%k;
        int size1=size/k;
        ListNode[] res=new ListNode[k];
        for(int i=0;i<k;i++){
            res[i]=temp;
            ListNode temp1=temp;
            for(int j=0;j<size1;j++){
                temp1=temp;
                temp=temp.next;
            }
            if(extra!=0){
                temp1=temp;
                temp=temp.next;
                extra--;
            }
            if(temp1!=null){
                temp1.next=null;
            }
        }
        return res;
    }
}