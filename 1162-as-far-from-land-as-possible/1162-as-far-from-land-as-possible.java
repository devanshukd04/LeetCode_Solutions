class Solution {
    class Pair{
        int x;
        int y;
        int cell;
        Pair(int x,int y,int cell){
            this.x=x;
            this.y=y;
            this.cell=cell;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> queue=new LinkedList<Pair>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        if(queue.size()==grid.length*grid[0].length){
            return -1;
        }
        return helper(grid,queue);
    }
    public int helper(int[][] grid, Queue<Pair> queue){
        int[] dir1=new int[]{0,0,-1,1};
        int[] dir2=new int[]{-1,1,0,0};
        int ans=-1;
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            ans=Math.max(ans,pair.cell);
            for(int i=0;i<4;i++){
                int x=pair.x+dir1[i];
                int y=pair.y+dir2[i];
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==0){
                    grid[x][y]=1;
                    queue.add(new Pair(x,y,pair.cell+1));
                }
            }
            
        }
        return ans;
    }
}