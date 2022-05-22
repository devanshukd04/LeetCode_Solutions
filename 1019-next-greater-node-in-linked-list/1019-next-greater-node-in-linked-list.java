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
    public int[] nextLargerNodes(ListNode head) {
        int n=0;
        int i=0;
        ListNode temp,temp1;;
        temp=head;
        while(temp!=null){
            temp=temp.next;
            ++n;
        }
        int [] array = new int[n];
        temp=head;
        while(temp!=null){
            temp1=temp.next;
            array[i]=0;
            while(temp1!=null){
                if(temp1.val>temp.val){
                    array[i]=temp1.val;
                    break;
                }
                else{
                    temp1=temp1.next;
                }
            }
            ++i;
            temp=temp.next;
        }
        return array;
    }
}