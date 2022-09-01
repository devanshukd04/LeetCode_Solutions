class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+2][2];
        dp[prices.length+1][0]=0;
        dp[prices.length+1][1]=0;
        dp[prices.length][0]=0;
        dp[prices.length][1]=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int take,notTake;
                if(j==1){
                    take=-prices[i]+dp[i+1][0];
                    notTake=dp[i+1][1];
                }
                else{
                    take=prices[i]+dp[i+2][1];
                    notTake=dp[i+1][0];
                }
                dp[i][j]=Math.max(take,notTake);
            }
        }
        return dp[0][1];
    }
    public int max(int[] prices,int buy,int index,int[][] dp){
        if(index>=prices.length){
            return 0;
        }
        int take;
        int notTake;
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        if(buy==1){
            take=-prices[index]+max(prices,0,index+1,dp);
            notTake=max(prices,1,index+1,dp);
        }
        else{
            take=prices[index]+max(prices,1,index+2,dp);
            notTake=max(prices,0,index+1,dp);
        }
        return dp[index][buy]=Math.max(take,notTake);
    }
}