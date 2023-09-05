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
        if(head==null){
            return null;
        }
        List<Node> list=new ArrayList<Node>();
        HashMap<Node,Node> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            list.add(new Node(temp.val));
            map.put(temp,list.get(list.size()-1));
            temp=temp.next;
        }
        temp=head;
        int index=0;
        while(temp!=null){
            
            if(temp.next!=null){
                list.get(index).next=list.get(index+1);
            }
            list.get(index).random=map.get(temp.random);
            index++;
            temp=temp.next;
        }
        return list.get(0);
    }
}