class Solution {
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return jump(nums,0,dp);
    }
    public boolean jump(int[] nums,int i,int[] dp){
        if(i>=nums.length-1){
            dp[nums.length-1]=1;
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==0?false:true;
        }
        for(int j=i+1;j<=i+nums[i];j++){
            if(jump(nums,j,dp)){
                dp[i]=1;
                return true;
            }
        }
        dp[i]=0;
        return false;
    }
}