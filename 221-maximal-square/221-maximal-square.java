class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        int[] dp=new int[matrix[0].length+1];
        int prev=0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(dp[j-1],Math.min(dp[j],prev))+1;
                    ans=Math.max(ans,dp[j]);   
                }
                else{
                    dp[j]=0;
                }
                prev=temp;
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