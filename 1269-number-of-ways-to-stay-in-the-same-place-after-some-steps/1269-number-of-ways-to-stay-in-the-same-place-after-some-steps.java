class Solution {
    int mod=(int)1e9+7;
    int[][] dp;
    int arrLen;
    public int numWays(int steps, int arrLen) {
        arrLen=Math.min(arrLen,steps);
        this.dp=new int[arrLen][steps+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        this.arrLen=arrLen;
        return helper(0,steps);
    }
    public int helper(int index, int steps){
        if(index<0 || index>=arrLen){
            return 0;
        }
        if(steps==0){
            if(index==0){
                return 1;
            }
            return 0;
        }
        if(dp[index][steps]!=-1){
            return dp[index][steps];
        }
        int ways=0;
        if(index<arrLen-1){
            ways=(ways+helper(index+1,steps-1))%mod;   
        }
        if(index>0){
            ways=(ways+helper(index-1,steps-1))%mod;   
        }
        ways=(ways+helper(index,steps-1))%mod;
        
        return dp[index][steps]=ways;
    }
}