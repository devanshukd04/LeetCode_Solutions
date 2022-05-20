class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] stat=new boolean[9];
        int a=0;
        int b=0;
        for(int i=0;i<stat.length;i++){
            stat[i]=true;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(stat[(board[i][j]-'0')-1]==true){
                        stat[(board[i][j]-'0')-1]=false;
                    }
                    else{
                        return false;
                    }
                }
            }
            for(int k=0;k<stat.length;k++){
            stat[k]=true;
        }
        }   
        for(int i=0;i<stat.length;i++){
            stat[i]=true;
        }
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][i]!='.'){
                    if(stat[(board[j][i]-'0')-1]==true){
                        stat[(board[j][i]-'0')-1]=false;
                    }
                    else{
                        return false;
                    }
                }
            }
            for(int k=0;k<stat.length;k++){
            stat[k]=true;
        }
        }
        System.out.println(a+""+b);
        while(a!=9){
            for(int i=0;i<stat.length;i++){
                stat[i]=true;
            }
            for(int i=a;i<a+3;i++){
                for(int j=b;j<b+3;j++){
                    if(board[i][j]!='.'){
                        if(stat[(board[i][j]-'0')-1]==true){
                            stat[(board[i][j]-'0')-1]=false;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            b+=3;
            if(b==9){
                a+=3;
                b=0;
            }
        }
        return true;
    }
}