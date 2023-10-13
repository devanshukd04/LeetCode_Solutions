class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        helper(cost,dp,0);
        return Math.min(dp[0],dp[1]);
    }
    public int helper(int[] cost, int[] dp, int index){
        if(index>=cost.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        dp[index]=cost[index]+Math.min(helper(cost,dp,index+1),helper(cost,dp,index+2));
        return dp[index];
    }
}