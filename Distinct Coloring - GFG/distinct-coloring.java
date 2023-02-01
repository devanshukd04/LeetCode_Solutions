//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        long[][] dp=new long[N+1][3];
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        dp[1][0]=r[0];
        dp[1][1]=g[0];
        dp[1][2]=b[0];
        for(int i=2;i<=N;i++){
            dp[i][0]=r[i-1]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=g[i-1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=b[i-1]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2]));
    }
    // public static long helper(int N,int curr,int[] r,int[] g,int[] b,int prev){
    //     if(curr>N){
    //         return 0;
    //     }
    //     long ans=Long.MAX_VALUE;
    //     if(dp[curr][prev+1]!=-1){
    //         return dp[curr][prev+1];
    //     }
    //     for(int i=0;i<3;i++){
    //         if(i==0 && prev!=i){
    //             ans=Math.min(ans,r[curr-1]+helper(N,curr+1,r,g,b,i));      
    //         }
    //         else if(i==1 && prev!=i){
    //             ans=Math.min(ans,g[curr-1]+helper(N,curr+1,r,g,b,i));   
    //         }
    //         else if(i==2 && prev!=i){
    //             ans=Math.min(ans,b[curr-1]+helper(N,curr+1,r,g,b,i));   
    //         }
    //     }
    //     return dp[curr][prev+1]=ans;
    // }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends