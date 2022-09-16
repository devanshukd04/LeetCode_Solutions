class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp=new int[multipliers.length+1][multipliers.length+1];
        
        for(int i=0;i<=multipliers.length;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i=multipliers.length-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j]=Math.max(multipliers[i]*nums[j]+dp[i+1][j+1],multipliers[i]*nums[nums.length-1-(i-j)]+dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
    public int helper(int[] nums,int[] multipliers,int[][] dp,int i,int k){
        if(k==multipliers.length){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int a=nums[nums.length-1-k+i]*multipliers[k]+helper(nums,multipliers,dp,i,k+1);
        int b=nums[i]*multipliers[k]+helper(nums,multipliers,dp,i+1,k+1);
        return dp[i][k]=Math.max(a,b);
    }
}