class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int[][] dp=new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return partition(0,nums,0,0,dp,sum/2);
    }
    public boolean partition(int index,int[] nums,int sum1,int sum2,int[][] dp,int sum){
        if(index==nums.length){
            if(sum1==sum2){
                return true;
            }
            return false;
        }
        if(sum1>sum || sum2>sum){
            return false;
        }
        if(dp[index][sum1]!=-1){
            return dp[index][sum1]==1?true:false;
        }
        boolean a=partition(index+1,nums,sum1+nums[index],sum2,dp,sum) || partition(index+1,nums,sum1,sum2+nums[index],dp,sum);
        if(a){
            dp[index][sum1]=1;
        }
        else{
            dp[index][sum1]=0;
        }
        return dp[index][sum1]==1?true:false;
    }
}