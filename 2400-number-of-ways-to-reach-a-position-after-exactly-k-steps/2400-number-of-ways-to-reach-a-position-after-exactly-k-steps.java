class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        //Creating a dp array
        int[][] dp=new int[3000][k+1];
        //Fill the dp array with -1
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(startPos,endPos,k,dp);
    }
    public int helper(int startPos,int endPos,int k,int[][] dp){
        //If startPos and endPos are equal and number of remaining steps are 0 then we have an answer so return 1
        if(startPos==endPos && k==0){
            return 1;
        }
        //If startPos and endPos are not equal but number of remaing steps are 0 then we do not have an answer so return 0
        if(k==0){
            return 0;
        }
        //If we have already calculated, so directly returning
        if(dp[startPos+1000][k]!=-1){
            return dp[startPos+1000][k];
        }
        //Moving one step left
        int left=helper(startPos-1,endPos,k-1,dp);
        //Moving one step right
        int right=helper(startPos+1,endPos,k-1,dp);
        //Storing the ans in dp
        dp[startPos+1000][k]=(left+right)%((int)1e9+7);
        return dp[startPos+1000][k];
    }
}