class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] dp=new int[values.length];
        dp[0]=values[0];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<values.length;i++){
            dp[i]=Math.max(dp[i-1],values[i]+i);
            ans=Math.max(ans,dp[i-1]+values[i]-i);
        }
        return ans;
    }
}