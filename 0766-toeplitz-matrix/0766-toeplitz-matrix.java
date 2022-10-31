class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=matrix[0].length-1;i>=0;i--){
            int row=0;
            int column=i;
            int value=matrix[row][column];
            row++;
            column++;
            while(row<=matrix.length-1 && column<=matrix[0].length-1){
                if(matrix[row][column]!=value){
                    return false;
                }
                row++;
                column++;
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            int row=i;
            int column=0;
            int value=matrix[row][column];
            row++;
            column++;
            while(row<=matrix.length-1 && column<=matrix[0].length-1){
                if(matrix[row][column]!=value){
                    return false;
                }
                row++;
                column++;
            }
        }
        return true;
    }
}