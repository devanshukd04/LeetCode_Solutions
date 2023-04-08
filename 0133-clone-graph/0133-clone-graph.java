/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] visited=new Node[101];
    HashSet<Integer> set=new HashSet<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        helper(node);
        return visited[node.val];
    }
    public void helper(Node node){
        if(set.contains(node.val)){
            return;
        }
        Node temp;
        if(visited[node.val]!=null){
            temp=visited[node.val];
        }
        else{
            temp=new Node(node.val);
        }
        visited[node.val]=temp;
        set.add(node.val);
        for(Node node1:node.neighbors){
            Node temp1;
            if(visited[node1.val]!=null){
                temp1=visited[node1.val];
            }
            else{
                temp1=new Node(node1.val);
            }
            visited[node1.val]=temp1;
            temp.neighbors.add(temp1);
            helper(node1);
        }
    }
}