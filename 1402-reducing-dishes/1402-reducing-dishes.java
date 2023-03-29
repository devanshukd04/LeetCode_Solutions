class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int[][] dp=new int[satisfaction.length+1][satisfaction.length+2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        Arrays.sort(satisfaction);
        return helper(dp,satisfaction,0,1);
    }
    public int helper(int[][] dp,int[] satisfaction,int index,int prevCount){
        if(index>=satisfaction.length){
            return 0;
        }
        if(dp[index][prevCount]!=-1){
            return dp[index][prevCount];
        }
        //noTake
        int notTake=helper(dp,satisfaction,index+1,prevCount);
        //take
        int take=satisfaction[index]*prevCount+helper(dp,satisfaction,index+1,prevCount+1);
        return dp[index][prevCount]=Math.max(take,notTake);
    }
}