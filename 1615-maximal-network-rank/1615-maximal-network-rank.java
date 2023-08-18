class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        int ans=0;
        int[] count=new int[n];
        for(int i=0;i<roads.length;i++){
            int pointA=roads[i][0];
            int pointB=roads[i][1];
            if(!map.containsKey(pointA)){
                map.put(pointA,new HashSet<Integer>());
            }
            if(!map.containsKey(pointB)){
                map.put(pointB,new HashSet<Integer>());
            }
            map.get(pointA).add(pointB);
            map.get(pointB).add(pointA);
            count[pointA]++;
            count[pointB]++;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.containsKey(i) && map.get(i).contains(j)){
                    ans=Math.max(ans,count[i]+count[j]-1);
                }
                else{
                    ans=Math.max(ans,count[i]+count[j]);
                }
            }
        }
        return ans;
    }
}