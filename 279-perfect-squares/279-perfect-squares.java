class Solution {
    public int numSquares(int n) {
        int index=(int)(Math.sqrt(n)+1);
        int[][] dp=new int[n+1][index+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=(int)1e5;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=index;j++){
                int take=(int)1e5;
                int notTake=dp[i][j-1];
                if(j*j<=i){
                    take=1+dp[i-j*j][j];
                }
                dp[i][j]=Math.min(take,notTake);
            }
        }
        return dp[n][index];
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