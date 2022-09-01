class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        dp[prices.length][0]=0;
        dp[prices.length][1]=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int take,notTake;
                if(j==1){
                    take=-prices[i]-fee+dp[i+1][0];
                    notTake=dp[i+1][1];
                }
                else{
                    take=prices[i]+dp[i+1][1];
                    notTake=dp[i+1][0];
                }
                dp[i][j]=Math.max(take,notTake);
            }
        }
        return dp[0][1];
    }
    public int max(int[] prices,int index,int buy,int fee,int[][] dp){
        if(index>=prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int take,notTake;
        if(buy==1){
            take=-prices[index]-fee+max(prices,index+1,0,fee,dp);
            notTake=max(prices,index+1,1,fee,dp);
        }
        else{
            take=prices[index]+max(prices,index+1,1,fee,dp);
            notTake=max(prices,index+1,0,fee,dp);
        }
        return dp[index][buy]=Math.max(take,notTake);
    }
}