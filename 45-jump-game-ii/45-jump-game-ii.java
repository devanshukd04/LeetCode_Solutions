class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,(int)1e4+1);
        return helper(nums,0,dp);
    }
    public int helper(int[] nums,int i,int[] dp){
        if(i==nums.length-1){
            return 0;
        }
        if(i>nums.length-1){
            return (int)1e4+1;
        }
        if(dp[i]!=(int)1e4+1){
            return dp[i];
        }
        for(int j=i+1;j<=i+nums[i];j++){
            dp[i]=Math.min(dp[i],1+helper(nums,j,dp));
        }
        return dp[i];
    }
}