class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int a=obstacleGrid.length;
        int b=obstacleGrid[0].length;
        int[][] c=new int[a][b];
        if(obstacleGrid[a-1][b-1]==1 || obstacleGrid[0][0]==1){
            return 0;
        }
        helper(obstacleGrid,0,0,c,a,b);
        if(c[0][0]==-1){
            return 0;
        }
        return c[0][0];
    }
    public List<Integer> helper(int[][] obstacleGrid,int i,int j,int[][] c,int a,int b){
        List<Integer> a2;
        List<Integer> a3;
        if(i==a-1 && j==b-1){
            c[i][j]=1;
            a2=new ArrayList<Integer>();
            a2.add(1);
            a2.add(1);
            return a2;
        }
        if(i>=a || j>=b || c[i][j]==-1){
            a2=new ArrayList<Integer>();
            a2.add(0);
            a2.add(0);
            return a2;
        }
        if(obstacleGrid[i][j]==1){
            c[i][j]=-1;
            a2=new ArrayList<Integer>();
            a2.add(0);
            a2.add(0);
            return a2;
        }
        if(c[i][j]!=-1 && c[i][j]!=0){
            a2=new ArrayList<Integer>();
            a2.add(1);
            a2.add(c[i][j]);
            return a2;
        }
        a2=helper(obstacleGrid,i+1,j,c,a,b);
        a3=helper(obstacleGrid,i,j+1,c,a,b);
        if(a2.get(0)==1 || a3.get(0)==1){
            List<Integer> a4=new ArrayList<Integer>();
            a4.add(1);
            a4.add(a2.get(1)+a3.get(1));
            c[i][j]=a2.get(1)+a3.get(1);
            return a4;
        }
        c[i][j]=-1;
        a2=new ArrayList<Integer>();
        a2.add(0);
        a2.add(0);
        return a2;
    }
}