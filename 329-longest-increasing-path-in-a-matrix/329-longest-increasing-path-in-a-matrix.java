class Solution {
    int max=Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int a=matrix.length;
        int b=matrix[0].length;
        int[][] c=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                helper(matrix,i,j,a,b,c);
            }
        }
        return max;
    }
    public int helper(int[][] matrix, int i, int j, int a, int b, int[][] c){
        int a1=1;
        int a2=1;
        int a3=1;
        int a4=1;
        int a5=0;
        if(i>=a){
            return 0;
        }
        if(j>=b){
            return helper(matrix,i+1,0,a,b,c);
        }
        if(c[i][j]!=0){
            return c[i][j];
        }
        if(j+1<b && matrix[i][j]<matrix[i][j+1]){
            a1=helper(matrix,i,j+1,a,b,c)+1;
        }
        if(j-1>=0 && matrix[i][j]<matrix[i][j-1]){
            a2=helper(matrix,i,j-1,a,b,c)+1;
        }
        if(i+1<a && matrix[i][j]<matrix[i+1][j]){
            a3=helper(matrix,i+1,j,a,b,c)+1;
        }
        if(i-1>=0 && matrix[i][j]<matrix[i-1][j]){
            a4=helper(matrix,i-1,j,a,b,c)+1;
        }
        a5=Math.max(Math.max(a1,a2),Math.max(a3,a4));
        c[i][j]=a5;
        if(max<a5){
            max=a5;
        }
        return a5;
    }
}