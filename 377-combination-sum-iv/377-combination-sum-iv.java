class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,dp,target);
    }
    public int helper(int[] nums,int[] dp,int target){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                ans+=helper(nums,dp,target-nums[i]);
            }
            else{
                return dp[target]=ans;
            }
        }
        return dp[target]=ans;
    }
}