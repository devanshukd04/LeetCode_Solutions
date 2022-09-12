class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    dp[i]+=dp[i-num];
                }
                else{
                    break;
                }
            }
        }
        return dp[target];
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