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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count;
        boolean flag=false;
        boolean flag1=true;
        ListNode temp=head,temp1;
        ListNode temp2,temp3=head;
        while(flag1){
            count=0;
            temp1=temp;
            while(count+1<k && temp!=null){
                temp=temp.next;
                count++;
            }
            if(count+1==k && temp!=null){
                
                temp2=temp.next;
                temp.next=null;
                ListNode thead=reverseGroup(temp1);
                if(!flag){
                    head=thead;
                    temp1.next=temp2;
                    flag=true;
                }
                else{
                    temp3.next=thead;
                    temp1.next=temp2;                }
                if(temp2==null){
                    return head;
                }
                else{
                    temp=temp2;
                    temp3=temp1; 
                }
            }
            else{
                return head;
            }
        }
        return head;
    }
    public ListNode reverseGroup(ListNode head){
        ListNode h1=head;
        ListNode temp,temp1;
        temp=head.next;
        head.next=null;
        while(temp!=null){
            temp1=temp.next;
            temp.next=h1;
            h1=temp;
            temp=temp1;
        }
        return h1;       
    }
}