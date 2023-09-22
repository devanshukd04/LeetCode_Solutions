class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int[][] wallArr=new int[cost.length][2];
        int totalTime=0;
        for(int i=0;i<cost.length;i++){
            wallArr[i][0]=cost[i];
            wallArr[i][1]=time[i];
            totalTime+=time[i];
        }
        int[][] dp=new int[cost.length][cost.length+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(wallArr,dp,0,cost.length);
    }  
    public int helper(int[][] arr, int[][] dp, int i, int sum){
        if(sum<=0){
            return 0;
        }
        if(i>=arr.length){
            return (int)1e9;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int take=arr[i][0]+helper(arr,dp,i+1,sum-1-arr[i][1]);
        int notTake=helper(arr,dp,i+1,sum);
        return dp[i][sum]=Math.min(take,notTake);
    }
}