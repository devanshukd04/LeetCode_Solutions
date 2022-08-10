class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int neg=0;
        for(int i=1;i<nums.length;i++){
            int house1=nums[i]+((i-2)<0?0:dp[i-2]);
            int house2=dp[i-1];
            dp[i]=Math.max(house1,house2);
        }
        return dp[nums.length-1];
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