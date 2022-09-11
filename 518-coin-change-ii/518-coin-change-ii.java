class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp=new int[amount+1][coins.length+1];
        for(int i=0;i<coins.length+1;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=coins.length;j++){
                if(i-coins[j-1]>=0){
                    dp[i][j]+=dp[i-coins[j-1]][j];    
                }
                dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[amount][coins.length];
    }
    public int helper(int amount,int[] coins,int[][] dp,int i){
        if(amount==0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        int ans=0;
        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }
        if(amount-coins[i]>=0){
            ans+=helper(amount-coins[i],coins,dp,i);    
        }
        ans+=helper(amount,coins,dp,i-1);
        return dp[amount][i]=ans;
    }
}