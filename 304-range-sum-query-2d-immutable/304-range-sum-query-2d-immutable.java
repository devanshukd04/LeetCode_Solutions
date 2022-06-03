class NumMatrix {
    int[][] matrix1;
    public NumMatrix(int[][] matrix) {
        matrix1=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            matrix1[i][0]=matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
                matrix1[i][j]=matrix1[i][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                sum+=matrix1[i][col2];
            }
            else{
                sum+=matrix1[i][col2]-matrix1[i][col1-1];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */