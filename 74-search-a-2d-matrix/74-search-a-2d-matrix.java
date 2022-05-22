class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a=matrix.length;
        int j=matrix[0].length-1; 
        int i=0;
        while(i<a && j>=0){
            if(matrix[i][j]>target){
                j--;
            }
            else if(matrix[i][j]<target){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}