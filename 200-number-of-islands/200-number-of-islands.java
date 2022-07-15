class Solution {
    boolean[][] check=new boolean[300][300];
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && check[i][j]==false){
                    ++count;
                    adjoiningArea(grid,i,j);
                }
            }
        }
        return count;
    }
    public void adjoiningArea(char[][] grid, int i, int j){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || check[i][j]==true){
            return;
        }
        else if(grid[i][j]=='0'){
            return;
        }
        check[i][j]=true;
        adjoiningArea(grid,i+1,j);
        adjoiningArea(grid,i-1,j);
        adjoiningArea(grid,i,j+1);
        adjoiningArea(grid,i,j-1);
    }
}