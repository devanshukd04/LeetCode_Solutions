class Solution {
    boolean[][] check =new boolean[50][50];
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && check[i][j]==false){
                    max=0;
                    adjoiningArea(grid,i,j);
                    ans=ans>max?ans:max;
                }
            }
        }
        return ans;
    }
    public void adjoiningArea(int[][] grid, int i, int j){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || check[i][j]==true){
            return;
        }
        else if(grid[i][j]==0){
            return;
        }
        check[i][j]=true;
        ++max;
        adjoiningArea(grid,i+1,j);
        adjoiningArea(grid,i-1,j);
        adjoiningArea(grid,i,j+1);
        adjoiningArea(grid,i,j-1);
    }
}