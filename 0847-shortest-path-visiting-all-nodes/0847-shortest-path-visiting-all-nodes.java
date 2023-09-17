class Solution {
    class Node{
        int vertex;
        int mask;
        int cost;
        Node(int vertex, int mask, int cost){
            this.vertex=vertex;
            this.mask=mask;
            this.cost=cost;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int nodes=graph.length;
        int finMask=(1<<nodes)-1;
        
        Set<Pair<Integer,Integer>> visited=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        
        for(int i=0;i<nodes;i++){
            int mask=(1<<i);
            Node node=new Node(i,mask,0);
            queue.add(node);
            visited.add(new Pair<>(i,mask));
        }
        
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node.mask==finMask){
                return node.cost;
            }
            for(int i=0;i<graph[node.vertex].length;i++){
                int targetVertex=graph[node.vertex][i];
                int targetMask=(1<<targetVertex);
                int destMask=node.mask | targetMask;
                
                Pair<Integer,Integer> pair=new Pair<>(targetVertex,destMask);
                if(visited.contains(pair)){
                    continue;
                }
                visited.add(pair);
                queue.add(new Node(targetVertex,destMask,node.cost+1));
            }
        }
        
        return -1;
    }
}