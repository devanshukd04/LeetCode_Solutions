class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return max(prices,1,0,dp);
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