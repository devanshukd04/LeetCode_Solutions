//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][][] dp;
    public int countWaystoDivide(int N, int K) {
        // Code here
        this.dp=new int[N+1][K+1][N+1];
        for(int[][] arr1:dp){
            for(int[] arr2:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        return helper(N,K,1);
    }
    public int helper(int N,int K,int prev){
        if(N<0){
            return 0;
        }
        else if(K==0){
            return N==0?1:0;
        }
        if(dp[N][K][prev]!=-1){
            return dp[N][K][prev];
        }
        int ans=0;
        for(int i=prev;i<=N;i++){
            ans+=helper(N-i,K-1,i);
        }
        dp[N][K][prev]=ans;
        return ans;
    }
}