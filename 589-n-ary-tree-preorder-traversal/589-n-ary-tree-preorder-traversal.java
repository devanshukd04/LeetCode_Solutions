/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root==null){
            return list;
        }
        List<Node> child=root.children;
        list.add(root.val);
        for(Node leaf:child){
            preorder(leaf);
        }
        return list;
    }
}