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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{   int mod=(int)1e9+7;
    public int CountWays(String str)
    {
        // code here
        int[][] dp=new int[str.length()][11];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(str,dp,0,-1);
    }
    public int helper(String str,int[][] dp,int index,int prev){
        if(index==str.length()){
            return 1;
        }
        int digit=str.charAt(index)-'0';
        int take=0;
        int notTake=0;
        if(prev==-1 && digit==0){
            return 0;
        }
        //take
        if(prev!=-1 && (prev*10+digit)>26 && digit==0){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        if(prev==-1){
            take=(take%mod+helper(str,dp,index+1,digit)%mod)%mod;
        }
        else{
            if(prev!=-1 && (prev*10+digit)<=26){
                take=(take%mod+helper(str,dp,index+1,-1)%mod)%mod;
            }
            if(digit!=0){
                notTake=(notTake%mod+helper(str,dp,index+1,digit)%mod)%mod;
            }
        }
        return dp[index][prev+1]=(take+notTake)%((int)1e9+7);
    }
}