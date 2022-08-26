class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return jumpGame(nums,0,dp);
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