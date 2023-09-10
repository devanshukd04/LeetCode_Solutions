class Solution {
    class Cell{
        int x;
        int y;
        int coins;
        Cell(int x, int y, int coins){
            this.x=x;
            this.y=y;
            this.coins=coins;
        }
    }
    public int minimumMoves(int[][] grid) {
        List<Cell> surplusCells=new ArrayList<>();
        List<Cell> emptyCells=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>1){
                    surplusCells.add(new Cell(i,j,grid[i][j]));
                }
                else if(grid[i][j]==0){
                    emptyCells.add(new Cell(i,j,0));
                }
            }
        }
        return helper(surplusCells,emptyCells,0);
    }
    public int helper(List<Cell> surplusCells, List<Cell> emptyCells, int emptyIndex){
        if(emptyIndex==emptyCells.size()){
            return 0;
        }
        int cost=Integer.MAX_VALUE;
        for(int i=0;i<surplusCells.size();i++){
            if(surplusCells.get(i).coins>1){
                --surplusCells.get(i).coins;
                
                int dist=Math.abs(emptyCells.get(emptyIndex).x-surplusCells.get(i).x)+Math.abs(emptyCells.get(emptyIndex).y-surplusCells.get(i).y);
                    
                cost=Math.min(cost,dist+helper(surplusCells,emptyCells,emptyIndex+1));
                ++surplusCells.get(i).coins;
            }
        }
        return cost;
    }
}