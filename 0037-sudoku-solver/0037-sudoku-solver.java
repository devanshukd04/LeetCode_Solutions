class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(int k=1;k<=9;k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=(char)(k+'0');
                            boolean flag=helper(board);
                            if(flag){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int x,int y,int digit){
        int x1=(x/3)*3;
        int y1=(y/3)*3;
        for(int i=0;i<9;i++){
            if(board[x][i]==(char)(digit+'0')){
                return false;
            }
            else if(board[i][y]==(char)(digit+'0')){
                return false;
            }
            else if(board[x1][y1++]==(char)(digit+'0')){
                return false;
            }
            if(y1==((y/3)*3+3)){
                y1=(y/3)*3;
                x1++;
            }
        }
        return true;
    }
}