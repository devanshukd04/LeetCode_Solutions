//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod=(int)1e9+7;
    static int[][] dp;
    static int uniquePaths(int n, int m, int[][] grid) {
        if(grid[n-1][m-1]==0){
            return 0;
        }
        // code here
        dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,n-1,m-1,grid);
    }
    public static int helper(int i,int j,int m,int n,int[][] grid){
        if(i==m && j==n && grid[i][j]==1){
            return 1;
        }
        if(i<0 || j<0 || i>m || j>n){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=helper(i+1,j,m,n,grid)%mod;
        int down=helper(i,j+1,m,n,grid)%mod;
        dp[i][j]=(right+down)%mod;
        return dp[i][j];
    }
};