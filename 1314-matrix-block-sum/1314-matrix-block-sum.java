class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] rowsum=new int[mat.length][mat[0].length];
        int[][] ans=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            rowsum[i][0]=mat[i][0];
            for(int j=1;j<mat[0].length;j++){
                rowsum[i][j]=rowsum[i][j-1]+mat[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ans[i][j]=helper(rowsum,mat,i,j,k);
            }
        }
        return ans;
    }
    public int helper(int[][] rowsum,int[][] mat,int i,int j,int k){
        int r1=i-k<0?0:i-k;
        int r2=i+k<rowsum.length?i+k:rowsum.length-1;
        int c1=j-k<0?0:j-k;
        int c2=j+k<rowsum[0].length?j+k:rowsum[0].length-1;
        int ans=0;
        for(int a=r1;a<=r2;a++){
            ans+=rowsum[a][c2]-rowsum[a][c1]+mat[a][c1];        
        }
        return ans;
    }
}