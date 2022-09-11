class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp=new int[amount+1][coins.length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(amount,coins,dp,coins.length-1);
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