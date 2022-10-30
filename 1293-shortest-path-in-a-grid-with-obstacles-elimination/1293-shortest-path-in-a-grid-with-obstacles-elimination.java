class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k+1];
        for(int[][] matrix:dp){
            for(int[] row:matrix){
                Arrays.fill(row,Integer.MAX_VALUE);
            }
        }
        int ans=helper(grid,grid.length-1,grid[0].length-1,k,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int helper(int[][] grid,int i,int j,int k,int[][][] dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]>1){
            return Integer.MAX_VALUE;
        }
        if(i==0 && j==0){
            return 0;
        }
        if(dp[i][j][k]!=Integer.MAX_VALUE){
            return dp[i][j][k];
        }
        if(k>=i+j){
            return dp[i][j][k]=i+j;
        }
        if(grid[i][j]==1 && --k<0){
            return Integer.MAX_VALUE;
        }
        int oldValue=grid[i][j];
        grid[i][j]=2;
        int minWays=Integer.MAX_VALUE;
        minWays=Math.min(minWays,helper(grid,i+1,j,k,dp));
        minWays=Math.min(minWays,helper(grid,i,j+1,k,dp));
        minWays=Math.min(minWays,helper(grid,i-1,j,k,dp));
        minWays=Math.min(minWays,helper(grid,i,j-1,k,dp));
        grid[i][j]=oldValue;
        return dp[i][j][k]=minWays==Integer.MAX_VALUE?minWays:minWays+1;
    }
}