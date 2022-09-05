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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while(queue.peek()!=null){
            List<Integer> ans=new ArrayList<Integer>();
            while(queue.peek()!=null){
                Node node=queue.remove();
                ans.add(node.val);
                List<Node> list=node.children;
                for(Node n:list){
                    queue.add(n);
                }
            }
            queue.remove();
            queue.add(null);
            res.add(ans);
        }
        return res;
    }
}