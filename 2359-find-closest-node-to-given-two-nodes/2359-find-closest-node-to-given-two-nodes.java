class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int node=-1;
        int max=Integer.MIN_VALUE;
        int[] visited=new int[edges.length];
        int[] distance1=new int[edges.length];
        int[] distance2=new int[edges.length];
        Arrays.fill(distance1,-1);
        Arrays.fill(distance2,-1);
        helper(edges,node1,visited,distance1,0);
        Arrays.fill(visited,0);
        helper(edges,node2,visited,distance2,0);
        for(int i=0;i<distance1.length;i++){
            if(distance1[i]!=-1 && distance2[i]!=-1){
                int currMax=distance1[i]>distance2[i]?distance1[i]:distance2[i];
                if(node==-1){
                    node=i;
                    max=currMax;
                }
                else{
                    if(max>currMax){
                        node=i;
                        max=currMax;
                    }
                }
            }
        }
        return node;
    }
    public void helper(int[] edges,int node,int[] visited,int[] distance,int path){
        if(visited[node]==1){
            return;
        }
        distance[node]=Math.max(path,distance[path]);
        visited[node]=1;
        if(edges[node]!=-1){
            helper(edges,edges[node],visited,distance,path+1);
        }
        return;
    }
}