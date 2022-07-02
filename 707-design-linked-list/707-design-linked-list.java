class MyLinkedList {
    class Node{
        int data;
        Node temp;
        Node(int val){
            this.data=val;
            this.temp=null;
        }
    }
    Node head;
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        Node a=head;
        int b=0;
        while(b<index && a!=null){
            b++;
            a=a.temp;
        }
        if(a==null){
            return -1;
        }
        return a.data;
    }
    
    public void addAtHead(int val) {
        Node a=new Node(val);
        a.temp=head;
        head=a;
        Node e=head;
    }
    
    public void addAtTail(int val) {
        Node a=head;
        while(a!=null && a.temp!=null){
            a=a.temp;
        }
        Node d=new Node(val);
        if(a==null){
            head=d;
        }
        else{
            a.temp=d;
        }
    }
    
    public void addAtIndex(int index, int val) {
        Node a=head;
        int b=0;
        while(b<index-1 && a.temp!=null){
            b++;
            a=a.temp;
        }
        if(index==0){
            Node d=new Node(val);
            d.temp=head;
            head=d;
        }
        else if(b==index-1 && a!=null){
            Node c=a.temp;
            Node d=new Node(val);
            a.temp=d;
            d.temp=c;
        }
    }
    
    public void deleteAtIndex(int index) {
        Node a=head;
        int b=0;
        while(b<index-1 && a!=null){
            b++;
            a=a.temp;
        }
        if(index==0){
            head=head.temp;
        }
        else if(a==null){
            a=a;
        }
        else if(a.temp==null){
            a=a.temp;
        }
        else{
            a.temp=a.temp.temp;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */