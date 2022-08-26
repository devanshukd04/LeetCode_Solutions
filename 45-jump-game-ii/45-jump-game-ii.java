class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]!=-1){
                for(int j=i+1;j<=i+nums[i] && j<nums.length;j++){
                    dp[j]=dp[j]!=-1?(Math.min(dp[j],dp[i]+1)):(dp[i]+1);
                }
            }
        }
        
        return dp[nums.length-1];
    }
    public int jumpGame(int[] nums, int i,int[] dp){
        int ans=Integer.MAX_VALUE;
        if(i>=nums.length-1){
            dp[nums.length-1]=1;
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i+1;j<=i+nums[i];j++){
            ans=Math.min(ans,jumpGame(nums,j,dp)+1);
        }
        return dp[i]=ans==Integer.MAX_VALUE?Integer.MAX_VALUE-100:ans;
    }
}