class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int a=obstacleGrid.length;
        int b=obstacleGrid[0].length;
        int[][] c=new int[a][b];
        if(obstacleGrid[a-1][b-1]==1 || obstacleGrid[0][0]==1){
            return 0;
        }
        //Calling helper function
        helper(obstacleGrid,0,0,c,a,b);
        if(c[0][0]==-1){
            return 0;
        }
        //Returning count from matrix c and row 0,,column 0
        return c[0][0];
    }
    public List<Integer> helper(int[][] obstacleGrid,int i,int j,int[][] c,int a,int b){
        List<Integer> a2;
        List<Integer> a3;
        int d;
        //Checking have we reach end position
        if(i==a-1 && j==b-1){
            c[i][j]=1;
            a2=new ArrayList<Integer>();
            a2.add(1);
            a2.add(1);
            return a2;
        }
        //Checking if we are going out of bound or checking if no solution
        if(i>=a || j>=b || c[i][j]==-1){
            a2=new ArrayList<Integer>();
            a2.add(0);
            a2.add(0);
            return a2;
        }
        //If obstacle found backtracking marking that position as -1 in matrix c
        if(obstacleGrid[i][j]==1){
            c[i][j]=-1;
            a2=new ArrayList<Integer>();
            a2.add(0);
            a2.add(0);
            return a2;
        }
        //If count already found return count
        if(c[i][j]!=-1 && c[i][j]!=0){
            a2=new ArrayList<Integer>();
            a2.add(1);
            a2.add(c[i][j]);
            return a2;
        }
        //Calling helper going to bottom
        a2=helper(obstacleGrid,i+1,j,c,a,b);
        //Calling helper going to right
        a3=helper(obstacleGrid,i,j+1,c,a,b);
        //Checking if atleast onefunction call leads to solution or not
        if(a2.get(0)==1 || a3.get(0)==1){
            List<Integer> a4=new ArrayList<Integer>();
            a4.add(1);
            //Doing addition of both the function call count and storing it in matrix 
            d=a2.get(1)+a3.get(1);
            a4.add(d);
            c[i][j]=d;
            return a4;
        }
        //If  no solution marking that position in matrix c as -1
        c[i][j]=-1;
        a2=new ArrayList<Integer>();
        a2.add(0);
        a2.add(0);
        return a2;
    }
}