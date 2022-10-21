class Solution {
    public int maxRotateFunction(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        int[] dp=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            dp[0]+=i*nums[i];
        }
        ans=ans<dp[0]?dp[0]:ans;
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]+sum-nums.length*nums[nums.length-i];
            ans=ans<dp[i]?dp[i]:ans;
        }
        return ans;
    }
}