class Solution {
    int fresh=0;
    public int orangesRotting(int[][] grid) {
        int minute=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ++fresh;
                }
            }
        }
        int[][] visited=new int[grid.length][grid[0].length];
        while(fresh>0){
            boolean flag=false;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==2 && visited[i][j]==0){
                        flag=true;
                        markFresh(grid,visited,i,j);
                    }
                }
             }
            for(int i=0;i<visited.length;i++){
                for(int j=0;j<visited[0].length;j++){
                    if(visited[i][j]==2){
                        visited[i][j]=0;
                    }
                }
            }
            if(!flag && fresh>0){
                return -1;
            }
            ++minute;
        }
        return minute;
    }
    public void markFresh(int[][] grid, int[][] visited,int i,int j){
        mark(grid,visited,i-1,j);
        mark(grid,visited,i+1,j);
        mark(grid,visited,i,j-1);
        mark(grid,visited,i,j+1);
        visited[i][j]=1;
        return;
    }
    public void mark(int[][] grid,int[][] visited,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            --fresh;
            grid[i][j]=2;
            visited[i][j]=2;
        }
        return;
    }
}