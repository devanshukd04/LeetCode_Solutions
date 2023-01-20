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
    public ListNode removeNodes(ListNode head) {
        ListNode temp=head;
        Stack<Integer> stack=new Stack<Integer>();
        while(temp!=null){
            while(!stack.isEmpty() && stack.peek()<temp.val){
                stack.pop();
            }
            stack.push(temp.val);
            temp=temp.next;
        }
        List<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        for(int i=0;i<list.size()/2;i++){
            int temp1=list.get(i);
            list.set(i,list.get(list.size()-i-1));
            list.set(list.size()-i-1,temp1);
        }
        ListNode head1=null;
        temp=head;
        ListNode temp1=null;
        int index=0;
        while(index!=list.size()){
            if(index==0 && list.get(index)==temp.val){
                head1=temp;
                temp1=temp;
                index++;
            }
            else if(list.get(index)==temp.val){
                temp1.next=temp;
                temp1=temp;
                index++;
            }
            temp=temp.next;
        }
        return head1;
    }
}