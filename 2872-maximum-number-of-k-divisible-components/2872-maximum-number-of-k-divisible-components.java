class Solution {
    private int count=0;
    private int k;
    class Node{
        int value;
        List<Node> neighbours=new ArrayList<>();
        Node(int value){
            this.value=value;
        }
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k=k;
        
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++){
            nodes[i]=new Node(values[i]);
        }
        for(int[] edge:edges){
            Node vertexA=nodes[edge[0]];
            Node vertexB=nodes[edge[1]];
            vertexA.neighbours.add(vertexB);
            vertexB.neighbours.add(vertexA);
        }
        
        getSum(nodes[0],null);
        return count;
    }
    public int getSum(Node node, Node parent){
        int sum=node.value;
        
        for(Node neighbour:node.neighbours){
            if(neighbour==parent){
                continue;
            }
            sum+=getSum(neighbour,node);
        }
        
        if(sum%k==0){
            count++;
            return 0;
        }
        return sum;
    }
}