class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        Arrays.fill(ans,-1);
        ans[0]=0;
        while(n>0){
            if(ans[n]==-1){
                ans[n]=countSetBit(ans,n);
            }
            n--;
        }
        return ans;
    }
    public int countSetBit(int[] dp,int num){
        if(num==0){
            return 0;
        }
        if(dp[num]!=-1){
            return dp[num];
        }
        return dp[num]=((num&1)==1?1:0)+countSetBit(dp,num/2);
    }
}