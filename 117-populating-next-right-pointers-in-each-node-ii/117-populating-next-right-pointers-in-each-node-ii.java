/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> a=new LinkedList<Node>();
        Node b;
        a.add(root);
        a.add(null);
        while(a.peek()!=null){
            while(a.peek()!=null){
                b=a.poll();
                if(b.left!=null){
                    a.add(b.left);
                }
                if(b.right!=null){
                    a.add(b.right);
                }
                b.next=a.peek();
            }
            a.poll();
            a.add(null);
        }
        return root;
    }
}