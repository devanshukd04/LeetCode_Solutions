class Solution {
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        int[] dp=new int[n];
        int a=1;
        int a1=2;
        int a2=3;
        int a3=5;
        int i1=0;
        int i2=0;
        int i3=0;
        int ans=1;
        while(a<n){
            ans=Math.min(a1,Math.min(a2,a3));
            dp[a]=ans;
            if(ans==a1){
                i1++;
                a1=dp[i1]*2;
            }
            if(ans==a2){
                i2++;
                a2=dp[i2]*3;
            }
            if(ans==a3){
                i3++;
                a3=dp[i3]*5;
            }
            a++;
        }
        return ans;
    }
}