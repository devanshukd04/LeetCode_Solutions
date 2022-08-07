class Solution {
    public int countVowelPermutation(int n) {
        int mod=(int)1e9+7;
        int ans=0;
        int[][] dp=new int[n][5];
        for(int i=0;i<5;i++){
            dp[n-1][i]=1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<5;j++){
                if(j==0){
                    dp[i][j]=dp[i+1][1];
                }
                else if(j==1){
                    dp[i][j]=(dp[i+1][0]+dp[i+1][2])%mod;
                }
                else if(j==2){
                    dp[i][j]=(dp[i][j]+dp[i+1][0])%mod;
                    dp[i][j]=(dp[i][j]+dp[i+1][1])%mod;
                    dp[i][j]=(dp[i][j]+dp[i+1][3])%mod;
                    dp[i][j]=(dp[i][j]+dp[i+1][4])%mod;
                }
                else if(j==3){
                    dp[i][j]=(dp[i+1][2]+dp[i+1][4])%mod;
                }
                else{
                    dp[i][j]=dp[i+1][0];
                }
            }
        }
        for(int j=0;j<5;j++){
            ans=(ans+dp[0][j])%mod;
        }
        return ans;
    }
}