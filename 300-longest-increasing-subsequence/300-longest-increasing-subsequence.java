class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        int max=1;
        for(int x:dp){
            max=Math.max(max,x);
        }
        return max;
    }
}