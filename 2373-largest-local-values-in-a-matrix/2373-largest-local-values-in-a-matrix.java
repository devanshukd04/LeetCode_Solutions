class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res=new int[grid.length-2][grid.length-2];
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid.length-2;j++){
                int max=-1;
                for(int a=i;a<i+3;a++){
                    for(int b=j;b<j+3;b++){
                        max=Math.max(max,grid[a][b]);
                    }
                }
                res[i][j]=max;
            }
        }
        return res;
    }
}