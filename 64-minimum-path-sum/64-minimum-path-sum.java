class Solution {
    int ans=Integer.MIN_VALUE;
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i>0 && j>0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
                else if(i>0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else if(j>0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else{
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    public int helper(int[][] grid,int[][] dp,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return (int)1e6+9;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=helper(grid,dp,i,j+1);
        int b=helper(grid,dp,i+1,j);
        return dp[i][j]=a<b?a+grid[i][j]:b+grid[i][j];
    }
}