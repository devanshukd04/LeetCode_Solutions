class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-2);
        }
        if(helper(grid,dp,0,0)==-1){
            return true;
        }
        grid[0][0]=1;
        for(int[] arr:dp){
            Arrays.fill(arr,-2);
        }
        if(helper(grid,dp,0,0)==-1){
            return true;
        }
        return false;
    }
    public int helper(int[][] grid,int[][] dp,int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return -1;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-2){
            return dp[i][j];
        }
        int horizontal=helper(grid,dp,i,j+1);
        if(horizontal==1){
            dp[i][j]=1;
            grid[i][j]=0;
            return 1;
        }
        int vertical=helper(grid,dp,i+1,j);
        if(vertical==1){
            dp[i][j]=1;
            grid[i][j]=0;
            return 1;
        }
        dp[i][j]=-1;
        return dp[i][j];
    }
}