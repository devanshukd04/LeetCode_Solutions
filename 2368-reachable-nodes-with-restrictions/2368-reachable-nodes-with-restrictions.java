class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        HashSet<Integer> set=new HashSet<Integer>();
        int ans=0;
        for(int num:restricted){
            set.add(num);
        }
        for(int i=0;i<edges.length;i++){
            if(!set.contains(edges[i][0]) && !set.contains(edges[i][1])){
                if(map.containsKey(edges[i][0])){
                    List<Integer> list=map.get(edges[i][0]);
                    list.add(edges[i][1]);
                }
                else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(edges[i][1]);
                    map.put(edges[i][0],list);
                }
                if(map.containsKey(edges[i][1])){
                    List<Integer> list=map.get(edges[i][1]);
                    list.add(edges[i][0]);
                }
                else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(edges[i][0]);
                    map.put(edges[i][1],list);
                }
                
            }
        }
        int[] visited=new int[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(0);
        visited[0]=1;
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans++;
            if(map.containsKey(node)){
                List<Integer> list=map.get(node);
                for(int num:list){
                    if(visited[num]!=1){
                        queue.add(num);
                        visited[num]=1;
                    }
                }
            }
        }
        return ans;
    }
}