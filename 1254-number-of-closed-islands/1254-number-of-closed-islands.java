class Solution {
    public int closedIsland(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0){
                land(grid,i,0,visited);
            }
            else{
                water(grid,i,0,visited);
            }
            if(grid[i][grid[0].length-1]==0){
                land(grid,i,grid[0].length-1,visited);
            }
            else{
                water(grid,i,grid[0].length-1,visited);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==0){
                land(grid,0,i,visited);
            }
            else{
                water(grid,0,i,visited);
            }
            if(grid[grid.length-1][i]==0){
                land(grid,grid.length-1,i,visited);
            }
            else{
                water(grid,grid.length-1,i,visited);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && visited[i][j]==0){
                    ans++;
                    land(grid,i,j,visited);
                }
                else if(grid[i][j]==1 && visited[i][j]==0){
                    water(grid,i,j,visited);
                }
            }
        }
        return ans;
    }
    public void water(int[][] grid,int i,int j,int[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==0){
            return;
        }
        visited[i][j]=1;
        water(grid,i+1,j,visited);
        water(grid,i,j+1,visited);
        water(grid,i-1,j,visited);
        water(grid,i,j-1,visited);
    }
    public void land(int[][] grid,int i,int j,int[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==1){
            return;
        }
        visited[i][j]=1;
        land(grid,i+1,j,visited);
        land(grid,i,j+1,visited);
        land(grid,i-1,j,visited);
        land(grid,i,j-1,visited);
    }
}