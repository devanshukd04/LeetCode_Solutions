class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        dp[nums.length-1]=Math.max(dp[nums.length-2],dp[nums.length-3]);
        int ans1=dp[nums.length-1];
        
        Arrays.fill(dp,0);
        dp[1]=nums[1];
        dp[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        dp[nums.length]=Math.max(dp[nums.length-1],dp[nums.length-2]);
        int ans2=dp[nums.length];
        
        return Math.max(ans1,ans2);
    }
}