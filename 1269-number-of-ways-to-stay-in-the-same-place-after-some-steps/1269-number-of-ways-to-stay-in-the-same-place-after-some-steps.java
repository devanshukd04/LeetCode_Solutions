class Solution {
    int mod=(int)1e9+7;
    public int numWays(int steps, int arrLen) {
        int[][] dp=new int[Math.min(arrLen,steps)][steps+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(dp,arrLen,0,steps);
    }
    public int helper(int[][] dp, int arrLen, int index, int steps){
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
        ways=(ways+helper(dp,arrLen,index+1,steps-1))%mod;
        ways=(ways+helper(dp,arrLen,index-1,steps-1))%mod;
        ways=(ways+helper(dp,arrLen,index,steps-1))%mod;
        
        return dp[index][steps]=ways;
    }
}