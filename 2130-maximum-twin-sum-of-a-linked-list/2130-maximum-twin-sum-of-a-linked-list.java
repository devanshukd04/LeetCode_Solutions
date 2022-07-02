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
    public int pairSum(ListNode head) {
        ListNode temp,temp1,temp2;
        int sum,maxsum;
        int n=0;
        temp=head;
        temp2=temp;
        temp1=temp;
        if(temp1==null){
            return 0;
        }
        while(temp1!=null){
            temp2=temp;
            temp=temp.next;
            n+=1;
            temp1=temp1.next.next;
        }
        if(n==1){
            return head.val+head.next.val;
        }
        temp1=temp2;
        temp2.next=null;
        temp2=temp.next;
        temp.next=null;
        while(temp2.next!=null){
            temp1=temp2.next;
            temp2.next=temp;
            temp=temp2;
            temp2=temp1;
        }
        temp2.next=temp;
        temp=head;
        maxsum=Integer.MIN_VALUE;
        while(temp!=null){
            sum=temp.val+temp2.val;
            if(sum>maxsum){
                maxsum=sum;
            }
            temp=temp.next;
            temp2=temp2.next;
        }
        return maxsum;
    }
}