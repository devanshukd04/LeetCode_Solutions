class Solution {
    public int uniquePaths(int m, int n) {
        int[][] c=new int[m][n];
        helper(0,0,c,m,n);
        return c[0][0];
    }
    public List<Integer> helper(int i,int j,int[][] c,int a,int b){
        List<Integer> a2;
        List<Integer> a3;
        if(i==a-1 && j==b-1){
            c[i][j]=1;
            a2=new ArrayList<Integer>();
            a2.add(1);
            return a2;
        }
        if(i>=a || j>=b){
            a2=new ArrayList<Integer>();
            a2.add(0);
            return a2;
        }
        if(c[i][j]!=0){
            a2=new ArrayList<Integer>();
            a2.add(c[i][j]);
            return a2;
        }
        a2=helper(i+1,j,c,a,b);
        a3=helper(i,j+1,c,a,b);
        List<Integer> a4=new ArrayList<Integer>();
        a4.add(a2.get(0)+a3.get(0));
        c[i][j]=a2.get(0)+a3.get(0);
        return a4;
    }
}

// Simple Solution
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] c=new int[m][n];
//         helper(0,0,c,m,n);
//         return c[0][0];
//     }
//     public int helper(int i,int j,int[][] c,int a,int b){
//         if(i==a-1 && j==b-1){
//             c[i][j]=1;
//             return c[i][j];
//         }
//         if(i>=a || j>=b){
//             return 0;
//         }
//         if(c[i][j]!=0){
//             return c[i][j];
//         }
//         int a2=helper(i+1,j,c,a,b);
//         int a3=helper(i,j+1,c,a,b);
//         c[i][j]=a2+a3;
//         return c[i][j];
//     }
// }
