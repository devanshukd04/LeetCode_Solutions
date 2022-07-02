class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr = new int[r][c];
        int a=0;
        int b=0;
         if(mat.length*mat[0].length!=r*c){
            return mat;
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(b>c-1){
                    b=0;
                    ++a;
            }
                arr[a][b]=mat[i][j];
                ++b;
        }
        }
    return arr;
    }
}