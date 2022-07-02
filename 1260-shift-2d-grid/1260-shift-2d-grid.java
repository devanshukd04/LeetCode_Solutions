class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int a,b,c,d;
        List<List<Integer>> matrix =new ArrayList<List<Integer>>();
        for(int i=0;i<k;i++){
            a=grid[0][0];
            for(int j=0;j<grid.length;j++){
                for(int e=0;e<grid[0].length;e++){
                    if(e+1==grid[0].length && j+1==grid.length){
                        b=0;
                        c=0;
                    }
                    else if(e+1==grid[0].length){
                        b=j+1;
                        c=0;
                    }
                    else{
                        b=j;
                        c=e+1;
                    }
                    d=a;
                    a=grid[b][c];
                    grid[b][c]=d;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
            matrix.add(list);
        }
        return matrix;
    }
}