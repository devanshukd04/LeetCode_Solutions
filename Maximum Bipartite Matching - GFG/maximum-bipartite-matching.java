//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int row=G.length;
        int col=G[0].length;
        int ans=helper(G,row,col);
        return ans;
    }
    public int helper(int[][] G,int row,int col){
        int[] match=new int[col];
        for(int i=0;i<col;i++){
            match[i]--;
        }
        int res=0;
        for(int i=0;i<row;i++){
            boolean[] visited=new boolean[col];
            if(helper1(G,i,visited,match,row,col)){
                res++;
            }
        }
        return res;
    }
    public boolean helper1(int[][] G,int index,boolean[] visited,int[] match,int row,int col){
        for(int i=0;i<col;i++){
            if(G[index][i]==1 && !visited[i]){
                visited[i]=true;
                if(match[i]<0 || helper1(G,match[i],visited,match,row,col)){
                    match[i]=index;
                    return true;
                }
            }
        }
        return false;
    }
}