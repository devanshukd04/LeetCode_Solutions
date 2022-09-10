class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][k+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int a=1;a<=k;a++){
                for(int j=0;j<=1;j++){
                    int take,notTake;
                    if(j==1){
                        take=-prices[i]+dp[i+1][a][0];
                        notTake=dp[i+1][a][1];
                    }
                    else{
                        take=prices[i]+dp[i+1][a-1][1];
                        notTake=dp[i+1][a][0];
                    }
                    dp[i][a][j]=Math.max(take,notTake);
                }   
            }
        }
        return dp[0][k][1];
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