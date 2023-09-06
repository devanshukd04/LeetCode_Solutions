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
        ListNode[] ans=new ListNode[k];
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        int partSize=length/k;
        int extra=length%k;
        temp=head;
        ListNode prev=temp;
        for(int i=0;i<k;i++){
            int prevSize=partSize;
            ans[i]=temp;
            while(temp!=null && prevSize>0){
                prev=temp;
                temp=temp.next;
                prevSize--;
            }
            if(extra>0){
                extra--;
                prev=temp;
                temp=temp.next;
            }
            if(prev!=null){
                prev.next=null;   
            }
        }
        return ans;
    }
}