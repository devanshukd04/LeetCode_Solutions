class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp=new long[n+1];
        int mod=(int)(1e9+7);
        dp[1]=1;
        long total=0;
        long sharing=0;
        long newsharing=0;
        long forgeting=0;
        for(int i=2;i<=n;i++){
            newsharing=i-delay>0?dp[i-delay]:0;
            forgeting=i-forget>0?dp[i-forget]:0;
            dp[i]=(sharing+newsharing-forgeting+mod)%mod;
            sharing=dp[i];
        }
        for(int i=n-forget+1;i<=n;i++){
            total=(total+dp[i])%(long)(1e9+7);
        }
        return (int)total;
    }
}