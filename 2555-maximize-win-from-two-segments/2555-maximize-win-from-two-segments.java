class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int res=0;
        int n=prizePositions.length;
        int j=0;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            while(k<prizePositions[i]-prizePositions[j]){
                ++j;
            }
            dp[i+1]=Math.max(dp[i],i-j+1);
            res=Math.max(res,i-j+1+dp[j]);
        }
        return res;
    }
}