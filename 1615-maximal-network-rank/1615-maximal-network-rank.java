class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        int ans=0;
        int[] count=new int[n];
        for(int[] road:roads){
            map.computeIfAbsent(road[0],k->new HashSet<>()).add(road[1]);
            map.computeIfAbsent(road[1],k->new HashSet<>()).add(road[0]);
            count[road[0]]++;
            count[road[1]]++;
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