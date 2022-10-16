class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        Integer[][] dp=new Integer[jobDifficulty.length][d+1];
        if(jobDifficulty.length<d){
            return -1;
        }
        return helper(jobDifficulty,0,dp,d);
    }
    public int helper(int[] jobDifficulty,int index,Integer[][] dp,int d){
        if(index==jobDifficulty.length && d==0){
            return 0;
        }
        if(jobDifficulty.length-index<d){
            return (int)1e5;
        }
        if(d<0){
            return (int)1e5;
        }
        if(dp[index][d]!=null){
            return dp[index][d];
        }
        int max=Integer.MIN_VALUE;
        int res=Integer.MAX_VALUE;
        for(int i=index;i<jobDifficulty.length;i++){
            max=Math.max(max,jobDifficulty[i]);
            res=Math.min(res,max+helper(jobDifficulty,i+1,dp,d-1));
        }
        return dp[index][d]=res;
    }
}