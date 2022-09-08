class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,0);
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                dp[0][i]=1;
                ans=dp[0][i];
            }
        }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                ans=dp[i][0];
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    ans=Math.max(ans,dp[i][j]);   
                }
            }
        }
        return ans*ans;
    }
    public int maximalSquareAns(char[][] matrix,int[][] dp,int i,int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=maximalSquareAns(matrix,dp,i-1,j);
        int b=maximalSquareAns(matrix,dp,i-1,j-1);
        int c=maximalSquareAns(matrix,dp,i,j-1);
        return dp[i][j]=Math.min(a,Math.min(b,c))+1;
    }
}