class Solution {
    public int numSquares(int n) {
        int j=(int)(Math.sqrt(n)+1);
        int[][] dp=new int[n+1][j+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(n,dp,j);
    }
    public int helper(int n,int[][] dp,int i){
        if(n==0){
            return 0;
        }
        if(i<=0){
            return (int)1e5;
        }
        if(dp[n][i]!=-1){
            return dp[n][i];
        }
        int take=(int)1e5;
        int notTake=helper(n,dp,i-1);
        if(i*i<=n){
            take=1+helper(n-i*i,dp,i);
        }
        return dp[n][i]=Math.min(take,notTake);
    }
}