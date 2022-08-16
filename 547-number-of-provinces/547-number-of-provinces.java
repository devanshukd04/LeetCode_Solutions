class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        int[] visited=new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    list.add(j);
                }
            }
            map.put(i,list);
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]!=1){
                visited[i]=1;
                queue.add(i);
                ans++;
                while(!queue.isEmpty()){
                    int pop=queue.poll();
                    List<Integer> list=map.get(pop);
                    for(int num:list){
                        if(visited[num]!=1){
                            queue.add(num);
                            visited[num]=1;
                        }
                    }
                }
            }
        }
        return ans;
    }
}