class Solution {
    int count=0;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        double M=10e9+7;
        int[][][] memo=new int[m][n][maxMove+1];
        for(int [][] outer:memo){
            for(int [] inner:outer){
                Arrays.fill(inner,-1);
            }
        }
        path(m,n,maxMove,startRow,startColumn,memo);
        memo[startRow][startColumn][maxMove]=memo[startRow][startColumn][maxMove]==-1?0:memo[startRow][startColumn][maxMove];
        return memo[startRow][startColumn][maxMove];
    }
    public int path(int m, int n, int maxMove, int i, int j, int[][][] memo){
        if(i>=m || i<0 || j>=n || j<0){
            return 1;
        }
        if(maxMove==0){
            return 0;
        }
        if(memo[i][j][maxMove]>=0){
            return memo[i][j][maxMove];
        }
        int a=path(m,n,maxMove-1,i+1,j,memo);
        int b=path(m,n,maxMove-1,i,j+1,memo);
        int c=path(m,n,maxMove-1,i-1,j,memo);
        int d=path(m,n,maxMove-1,i,j-1,memo);
        double M=1e9+7;
        double sum=((a+b)%M+(c+d)%M)%M;
        memo[i][j][maxMove]=(int)sum;
        return memo[i][j][maxMove];
    }
}