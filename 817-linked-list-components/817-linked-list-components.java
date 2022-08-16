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
    public int numComponents(ListNode head, int[] nums) {
        int res=0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp.val)){
                ++res;
                set.remove(temp.val);
                temp=temp.next;
                while(temp!=null && set.contains(temp.val)){
                    set.remove(temp.val);
                    temp=temp.next;
                }
            }
            else{
                temp=temp.next;
            }
        }
        return res;
    }
}