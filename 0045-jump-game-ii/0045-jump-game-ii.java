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
    public int helper(int[] nums, int index,int[] dp){
        int ans=(int)1e6;
        if(index>=nums.length-1){
            return 0;
        }
        int step=nums[index];
        if(dp[index]!=-1){
            return dp[index];
        }
        for(int i=1;i<=step;i++){
            int temp=1+helper(nums,index+i,dp);
            ans=Math.min(ans,temp);
        }
        return dp[index]=ans;
    }
}