class Solution {
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,(int)1e4+1);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]!=(int)1e4+1){
                for(int j=i+1;j<=i+nums[i];j++){
                    if(j<nums.length){
                        dp[j]=Math.min(dp[j],dp[i]+1);
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return dp[dp.length-1]!=(int)1e4+1?true:false;
    }
    
}