class Solution {
    List<List<String>> a1=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        char[][] a=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]='.';
            }
        }
        queens(a,0,n);
        return a1;
    }
    public void queens(char[][] board, int i, int n){
        if(i==n){
            List<String> a2=generate(board);
            a1.add(a2);
        }
        for(int j=0;j<n;j++){
            if(safe(board,i,j,n)){
                board[i][j]='Q';
                queens(board,i+1,n);
                board[i][j]='.';
            }
        }
    }
    public List<String> generate(char[][] board){
        List<String> a=new ArrayList<String>();
        for(char[] a2:board){
            a.add(String.valueOf(a2));
        }
        return a;
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