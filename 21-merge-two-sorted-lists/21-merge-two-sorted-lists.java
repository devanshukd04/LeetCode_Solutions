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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp,temp1,temp2,temp3,temp4;
        temp=list1;
        temp1=list2;
        if(temp==null && temp1!=null){
            return temp1;
        }
        else if(temp!=null && temp1==null){
            return temp;
        }
        else if(temp==null || temp1==null){
            return temp1;
        }
        if(temp.val<=temp1.val){
            temp2=temp;
            temp=temp.next;
        }
        else{
            temp2=temp1;
            temp1=temp1.next;
        }
        temp3=temp2;
        while(temp!=null && temp1!=null){
            if(temp.val<=temp1.val){
                temp2.next=temp;
                temp2=temp;
                temp=temp.next;
            }
            else {
                temp2.next=temp1;
                temp2=temp2.next;
                temp1=temp1.next;
            }
        }
        if(temp!=null && temp1==null){
            while(temp!=null){
            temp2.next=temp;
            temp2=temp2.next;
            temp=temp.next;
        }
        }
        else{
           while(temp1!=null){
            temp2.next=temp1;
            temp2=temp2.next;
            temp1=temp1.next;
        } 
        }
      return temp3;  
    }
}