//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		int[][] dp=new int[N+1][4];
		int mod=(int)1e9+7;
		dp[0][3]=1;
		for(int i=1;i<=N;i++){
		    dp[i][0]=((dp[i-1][1]+dp[i-1][2])%mod+dp[i-1][3])%mod;
		    dp[i][1]=((dp[i-1][0]+dp[i-1][2])%mod+dp[i-1][3])%mod;
		    dp[i][2]=((dp[i-1][0]+dp[i-1][1])%mod+dp[i-1][3])%mod;
		    dp[i][3]=((dp[i-1][0]+dp[i-1][1])%mod+dp[i-1][2])%mod;
		}
		return dp[N][3];
	}
// 	public static int helper(HashMap<Character,List<Character>> map,int N,char ch){
// 	    int alphabet=ch-'A';
// 	    if(alphabet>2){
// 	        alphabet=3;
// 	    }
// 	    if(N==0 && ch=='O'){
// 	        return 1;
// 	    }
// 	    else if(N==0){
// 	        return 0;
// 	    }
// 	    List<Character> list=map.get(ch);
// 	    if(dp[N][alphabet]!=-1){
// 	        return dp[N][alphabet];
// 	    }
// 	    int ans=0;
// 	    for(int i=0;i<list.size();i++){
// 	        ans=(ans+(helper(map,N-1,list.get(i)))%mod)%mod;
// 	    }
// 	    dp[N][alphabet]=ans;
// 	    return dp[N][alphabet];
// 	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends