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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0,d=0;
        ListNode temp,temp1,temp2=l1;
        temp=l1;
        while(temp.next!=null){
            temp=temp.next;
            ++c;
        }
        temp=l2;
        while(temp.next!=null){
            temp=temp.next;
            ++d;
        }
        if(c>d){
            temp=l1;
            temp1=l2;
            c=0;
            while(temp1!=null){
                c+=temp.val+temp1.val;
                if(c>=10){
                    temp.val=c%10;
                    c=1;
                }
                else{
                    temp.val=c;
                    c=0;
                }
                temp2=temp;
                temp1=temp1.next;
                temp=temp.next;
            }
            while(temp!=null){
                c+=temp.val;
                if(c>=10){
                    temp.val=c%10;
                    c=1;
                }
                else{
                    temp.val=c;
                    c=0;
                }
                temp2=temp;
                temp=temp.next;
            }
            if(c!=0){
                ListNode temp3=new ListNode(c);
                temp2.next=temp3;
                temp3.next=null;
            }
            return l1;
        }
        else{
            temp=l1;
            temp1=l2;
            c=0;
            while(temp!=null){
                c+=temp.val+temp1.val;
                if(c>=10){
                    temp1.val=c%10;
                    c=1;
                }
                else{
                    temp1.val=c;
                    c=0;
                }
                temp2=temp1;
                temp1=temp1.next;
                temp=temp.next;
            }
            while(temp1!=null){
                c+=temp1.val;
                if(c>=10){
                    temp1.val=c%10;
                    c=1;
                }
                else{
                    temp1.val=c;
                    c=0;
                }
                temp2=temp1;
                temp1=temp1.next;
            }
            if(c!=0){
                ListNode temp3=new ListNode(c);
                temp2.next=temp3;
                temp3.next=null;
            }
            return l2;
        }
    }
}