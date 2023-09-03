class Solution {
    public int uniquePaths(int m, int n) {
        int[][] c=new int[m][n];
        helper(0,0,c,m,n);
        return c[0][0];
    }
    public int helper(int i,int j,int[][] c,int a,int b){
        if(i==a-1 && j==b-1){
            c[i][j]=1;
            return c[i][j];
        }
        if(i>=a || j>=b){
            return 0;
        }
        if(c[i][j]!=0){
            return c[i][j];
        }
        int a2=helper(i+1,j,c,a,b);
        int a3=helper(i,j+1,c,a,b);
        c[i][j]=a2+a3;
        return c[i][j];
    }
}