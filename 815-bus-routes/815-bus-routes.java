class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        HashMap<Integer,HashSet<Integer>> map=new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                HashSet<Integer> busRoute=map.containsKey(routes[i][j])?map.get(routes[i][j]):new HashSet<Integer>();
                busRoute.add(i);
                map.put(routes[i][j],busRoute);
            }
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        int count=0;
        HashSet<Integer> visited=new HashSet<Integer>();
        while(!queue.isEmpty()){
            count++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curStop=queue.poll();
                HashSet<Integer> buses=map.get(curStop);
                for(Integer bus:buses){
                    if(visited.add(bus)){
                        for(Integer stop:routes[bus]){
                            if(stop==target){
                                return count;
                            }
                            queue.add(stop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}