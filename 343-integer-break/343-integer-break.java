class Solution {
    public int integerBreak(int n) {
        int[][] dp=new int[n+1][n+1];
        if(n==2 || n==3){
            return n==2?1:2;
        }
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(n,dp,1);
    }
    public int helper(int n,int[][] dp,int i){
        if(n==0){
            return 1;
        }
        if(i>n || n<0){
            return 0;
        }
        if(dp[n][i]!=-1){
            return dp[n][i];
        }
        int notTake=helper(n,dp,i+1);
        int take=i*helper(n-i,dp,i);
        return dp[n][i]=Math.max(take,notTake);
    }
}