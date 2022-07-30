class Solution {
    public int[] findBall(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] ans=new int[n];
        
        for(int j=0;j<n;j++){
            ans[j]=checkBallFallsOut(grid,0,j,m,n);
        }
        return ans;
    }
    private int checkBallFallsOut(int[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>m || j>=n){
            return -1;
        }
        if(i==m){
            return j;
        }
        if(grid[i][j]==-1){
            if(j>0 && grid[i][j-1]==1){
                return -1;
            }
            return checkBallFallsOut(grid,i+1,j-1,m,n);
        }
        else{
            if(j<n-1 && grid[i][j+1]==-1){
                return -1;
            }
            return checkBallFallsOut(grid,i+1,j+1,m,n);
        }
    }
}