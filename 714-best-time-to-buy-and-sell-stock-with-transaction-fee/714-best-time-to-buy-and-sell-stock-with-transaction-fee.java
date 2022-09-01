class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return max(prices,0,1,fee,dp);
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