class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        int i=2;
        while(i<=n){
            for(int j=0;j<i;j++){
                dp[i]=dp[i]+dp[i-j-1]*dp[j];
            }
            i++;
        }
        return dp[n];
    }
}