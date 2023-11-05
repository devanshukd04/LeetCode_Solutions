class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<=edges.length;i++){
            map.put(i,new ArrayList<Integer>());
        }
        
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        long sum=0;
        for(int num:values){
            sum+=(long)num;
        }
        
        
        return sum-helper(map,values,0,-1);
    }
    public long helper(Map<Integer,List<Integer>> map, int[] values, int node, int parent){
        if(map.get(node).size()==1 && node!=0){
            return values[node];
        }
        
        long ans=0;
        
        for(int childNode:map.get(node)){
            if(childNode==parent){
                continue;
            }
            ans+=helper(map,values,childNode,node);
        }
        
        return ans<values[node]?ans:values[node];
    }  
}