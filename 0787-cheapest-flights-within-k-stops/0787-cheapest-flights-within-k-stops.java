class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //visited array
        int[] visited=new int[n];
        //2-D dp 
        int[][] dp=new int[n][k+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        //Sortingthe array to first try shorter paths
        Arrays.sort(flights,(a,b)->a[2]-b[2]);
        //Using amp to store possible nodes from a node
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<flights.length;i++){
            map.get(flights[i][0]).add(i);
        }
        int ans=helper(map,flights,dp,visited,src,dst,k);
        return ans>=1e6?-1:ans;
    }
    public int helper(HashMap<Integer,List<Integer>> map,int[][] flights,int[][] dp,int[] visited,int current,int dst,int k){
        //If number of stops>k || if stop is visited before backtrack
        if(k<0 || visited[current]==1){
            return (int)1e7;
        }
        //USing dp array to return values calculate before
        if(dp[current][k]!=-1){
            return dp[current][k];
        }
        //Maarking the stop as visited
        visited[current]=1;
        //Initialize ans to a bigger value
        int ans=(int)1e7;
        List<Integer> list=map.get(current);
        //Getting all possible stops from given node
        for(int num:list){
            //Chacking if that stop is visited so far
            if(visited[flights[num][1]]!=1){
                //If the next stop is the destinnation stop updating the ans
                if(flights[num][1]==dst){
                    ans=Math.min(ans,flights[num][2]);
                }
                else{
                    //Calling function for next stop
                    ans=Math.min(ans,flights[num][2]+helper(map,flights,dp,visited,flights[num][1],dst,k-1));
                }
            }
        }
        //Storing ans in dp array
        dp[current][k]=ans;
        //Marking stop as unvisited
        visited[current]=0;
        return ans;
    }
}