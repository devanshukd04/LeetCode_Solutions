class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res=Integer.MAX_VALUE;
        int[][] dp=new int[matrix.length][matrix[0].length];
        int[][] visited=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<matrix[0].length;i++){
            res=Math.min(res,helper(matrix,0,i,dp,visited));
        }
        return res;
    }
    public int helper(int[][] matrix,int i,int j,int[][] dp,int[][] visited){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return (int)1e7;
        }
        int a=0;
        int b=0;
        int c=0;
        if(visited[i][j]!=0){
            return dp[i][j];
        }
        if(i<matrix[0].length-1){
            a=helper(matrix,i+1,j,dp,visited);
            b=helper(matrix,i+1,j-1,dp,visited);    
            c=helper(matrix,i+1,j+1,dp,visited);     
        }
        else{
            return matrix[i][j];
        }
        int d=matrix[i][j]+Math.min(a,Math.min(b,c));
        dp[i][j]=d;
        visited[i][j]=1;
        return d;
    }
}