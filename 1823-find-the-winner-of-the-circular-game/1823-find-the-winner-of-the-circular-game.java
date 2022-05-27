class Solution {
    class Node{
        int data;
        Node next;
        Node(int val){
            this.data=val;
            this.next=null;
        }
    }
    public int findTheWinner(int n, int k) {
        int i;
        Node a=new Node(0);
        Node c=a;
        Node d;
        for(int j=1;j<=n;j++){
            Node b=new Node(j);
            a.next=b;
            a=b;
        }
        c=c.next;
        a.next=c;
        d=a;
        a=c;
        while(a.next!=a){
            i=1;
            while(i<k){
                d=a;
                a=a.next;
                ++i;
            }
            d.next=a.next;
            a=d.next;
        }
        return a.data;
    }
}