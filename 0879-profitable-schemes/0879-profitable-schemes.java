class Solution {
    int mod=(int)1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Integer[][][] dp=new Integer[n+1][group.length][minProfit+1];
        return helper(dp,n,0,minProfit,group,profit);
    }
    public int helper(Integer[][][] dp,int n,int index,int minProfit,int[] group,int[] profit){
        if(index>=group.length){
            return minProfit==0?1:0;
        }
        if(dp[n][index][minProfit]!=null){
            return dp[n][index][minProfit];
        }
        int take=0;
        int notTake=0;
        notTake=helper(dp,n,index+1,minProfit,group,profit);
        if(group[index]<=n){
            int temp=minProfit-profit[index];
            temp=temp<=0?0:temp;
            take=helper(dp,n-group[index],index+1,temp,group,profit);
        }
        dp[n][index][minProfit]=(take%mod+notTake%mod)%mod;
        return dp[n][index][minProfit];
    }
}