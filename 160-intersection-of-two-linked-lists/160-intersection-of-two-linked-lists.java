/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a=0;
        int b=0;
        ListNode temp,temp1;
        temp=headA;
        while(temp!=null){
            temp=temp.next;
            ++a;
        }
        temp=headB;
        while(temp!=null){
            temp=temp.next;
            ++b;
        }
        if(a<b){
            b-=a;
            temp=headA;
            temp1=headB;
            while(b!=0){
                temp1=temp1.next;
                --b;
            }
            while(a!=0){
                if(temp==temp1){
                    return temp;
                }
                temp=temp.next;
                temp1=temp1.next;
            }
        }
        else{
            a-=b;
            temp=headA;
            temp1=headB;
            while(a!=0){
                temp=temp.next;
                --a;
            }
            while(b!=0){
                if(temp==temp1){
                    return temp;
                }
                temp=temp.next;
                temp1=temp1.next;
            }
        }
        return null;
    }
}