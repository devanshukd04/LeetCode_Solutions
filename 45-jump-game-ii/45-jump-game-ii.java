class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,(int)1e4+1);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+nums[i];j++){
                if(j<nums.length){
                    dp[j]=Math.min(dp[j],dp[i]+1);
                }
                else{
                    dp[nums.length-1]=Math.min(dp[nums.length-1],dp[i]+1);
                }
            }
        }
        return dp[nums.length-1];
        
    }
}