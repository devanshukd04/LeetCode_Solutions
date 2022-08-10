class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return rob(nums,dp,nums.length-1);
    }
    public int rob(int[] nums,int[] dp,int i){
        if(i==0){
            return nums[i];
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int house1=nums[i]+rob(nums,dp,i-2);
        int house2=rob(nums,dp,i-1);
        
        return dp[i]=Math.max(house1,house2);
    }
}