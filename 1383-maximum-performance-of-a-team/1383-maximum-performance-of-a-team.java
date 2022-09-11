class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players=new int[speed.length][2];
        for(int i=0;i<speed.length;i++){
            players[i][0]=speed[i];
            players[i][1]=efficiency[i];
        }
        Arrays.sort(players,(a,b)->(b[1]-a[1]));
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k);
        long teamPerformance=0;
        long teamSpeed=0;
        for(int i=0;i<speed.length;i++){
            if(queue.size()>=k){
                teamSpeed-=queue.remove();
            }
            queue.add(players[i][0]);
            teamSpeed+=players[i][0];
            teamPerformance=Math.max(teamPerformance,teamSpeed*players[i][1]);
        }
        return (int)(teamPerformance%1000000007);
    }
}