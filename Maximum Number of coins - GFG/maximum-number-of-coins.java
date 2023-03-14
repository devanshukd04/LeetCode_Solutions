//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp;
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		int[] a=new int[N+2];
		int n=a.length;
		a[0]=1;
		a[n-1]=1;
		for(int i=1;i<=n-2;i++){
		    a[i]=arr.get(i-1);
		}
		dp=new int[n][n];
		for(int[] row:dp){
		    Arrays.fill(row,-1);
		}
		return solve(a,0,n-1);
	}
	static int solve(int[] a,int start,int end){
	    if(end-start==1){
	        return 0;
	    }
	    if(dp[start][end]!=-1){
	        return dp[start][end];
	    }
	    int ans=0;
	    for(int m=start+1;m<end;m++){
	        int curr=a[start]*a[m]*a[end]+solve(a,start,m)+solve(a,m,end);
	        ans=Math.max(ans,curr);
	    }
	    return dp[start][end]=ans;
	}
}