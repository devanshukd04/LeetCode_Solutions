class Solution {
    public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length;i++){
            int current;
            int house1=nums[i]+prev2;
            int house2=prev;
            current=Math.max(house1,house2);
            prev2=prev;
            prev=current;
        }
        return prev;
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