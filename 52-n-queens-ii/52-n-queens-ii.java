class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char[][] a=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]='.';
            }
        }
        queens(a,0,n);
        return count;
    }
    public void queens(char[][] board, int i, int n){
        if(i==n){
            ++count;
        }
        for(int j=0;j<n;j++){
            if(safe(board,i,j,n)){
                board[i][j]='Q';
                queens(board,i+1,n);
                board[i][j]='.';
            }
        }
    }
    public boolean safe(char[][] board, int row, int column, int n){
        for(int i=0;i<=row;i++){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        for(int i=row,j=column;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row,j=column;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}