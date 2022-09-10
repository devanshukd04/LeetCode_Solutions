class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][k+1][2];
        return profit(k,prices,dp,0,1);
    }
    public int profit(int k,int[] prices,int[][][] dp,int i,int flag){
        if(i==prices.length || k==0){
            return 0;
        }
        if(dp[i][k][flag]!=0){
            return dp[i][k][flag];
        }
        int take,notTake;
        if(flag==1){
            take=-prices[i]+profit(k,prices,dp,i+1,0);
            notTake=profit(k,prices,dp,i+1,flag);
        }
        else{
            take=prices[i]+profit(k-1,prices,dp,i+1,1);
            notTake=profit(k,prices,dp,i+1,flag);
        }
        return dp[i][k][flag]=Math.max(take,notTake);
    }
}