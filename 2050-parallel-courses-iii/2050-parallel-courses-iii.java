class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        int[] inDegree=new int[n+1];
        int[] maxTime=new int[n+1];
        
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<Integer>());
        }
        
        for(int[] relation:relations){
            inDegree[relation[1]]++;
            map.get(relation[0]).add(relation[1]);
        }
        
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                queue.add(i);
                maxTime[i]=time[i-1];
            }
        }
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbour:map.get(node)){
                maxTime[neighbour]=Math.max(maxTime[neighbour],maxTime[node]+time[neighbour-1]);
                if(--inDegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=ans>maxTime[i]?ans:maxTime[i];
        }
        
        return ans;
    }
}