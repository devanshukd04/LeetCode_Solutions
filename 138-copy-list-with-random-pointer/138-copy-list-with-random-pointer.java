/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        int i=0;
        Node temp,temp1;
        temp=head;
        Node temp2=head;
        HashMap<Integer,Node> map1=new HashMap<Integer,Node>();
        HashMap<Node,Integer> map2=new HashMap<Node,Integer>();
        while(temp!=null){
            temp2=new Node(temp.val);
            map1.put(i,temp2);
            map2.put(temp,i);
            i++;
            temp=temp.next;
        }
        temp=head;
        i=0;
        while(temp!=null){
            temp2=map1.get(i);
            if(temp.next!=null){
                temp2.next=map1.get(map2.get(temp.next));
            }
            else{
                temp2.next=null;
            }
            if(temp.random!=null){
                temp2.random=map1.get(map2.get(temp.random));
            }
            else{
                temp2.random=null;
            }
            i++;
            temp=temp.next;
        }
        return map1.get(0);
    }
}