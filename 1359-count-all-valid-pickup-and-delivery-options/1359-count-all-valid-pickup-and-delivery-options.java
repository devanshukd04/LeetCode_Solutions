class Solution {
    public int countOrders(int n) {
        int mod=(int)1e9+7;
        long ans=1;
        for(int i=2;i<=n;i++){
            ans=(ans*(2*i-1)*i)%mod;
        }
        return (int)ans;
    }
}