class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        Integer[][][] dp =new Integer[grid.length][grid[0].length][k];
        return helper(grid,0,0,dp,k,0);
    }
    public int helper(int[][] grid,int i,int j,Integer[][][] dp,int k,int currsum){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        currsum+=grid[i][j];
        currsum%=k;
        if(i==grid.length-1 && j==grid[0].length-1){
            return currsum%k==0?1:0;
        }
        if(dp[i][j][currsum]!=null){
            return dp[i][j][currsum];
        }
        int a=helper(grid,i+1,j,dp,k,currsum);
        int b=helper(grid,i,j+1,dp,k,currsum);
        return dp[i][j][currsum]=(a+b)%((int)(1e9)+7);
    }
   
}