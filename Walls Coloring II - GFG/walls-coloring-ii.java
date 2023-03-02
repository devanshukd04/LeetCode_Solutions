//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int[][] dp;
	int minCost(int [][] costs) {
		//Write your code here
		this.dp=new int[costs.length][costs[0].length+1];
// 		for(int[] arr:dp){
// 		    Arrays.fill(arr,-1);
// 		}
		if(costs[0].length==1 && costs.length>1){
		    return -1;
		}
		int min1=Integer.MAX_VALUE;
		int min2=min1;
		for(int i=0;i<costs[0].length;i++){
		    dp[0][i]=costs[0][i];
		    if(min1==Integer.MAX_VALUE){
	            min1=i;
	        }
	        else if(dp[0][i]<=dp[0][min1]){
		        min2=min1;
		        min1=i;
		    }
		    else if(min2==Integer.MAX_VALUE){
		        min2=i;
		    }
		    else if(dp[0][i]<=dp[0][min2]){
		        min2=i;
		    }
		}
        
		for(int i=1;i<costs.length;i++){
		    int temp1=Integer.MAX_VALUE;
		    int temp2=temp1;
		    for(int j=0;j<costs[0].length;j++){
		        
		        if(j==min1){
		            dp[i][j]+=dp[i-1][min2]+costs[i][j];
		        }
		        else{
		            dp[i][j]+=dp[i-1][min1]+costs[i][j];
		        }
		        
		        if(temp1==Integer.MAX_VALUE){
		            temp1=j;
		        }
		        else if(dp[i][j]<=dp[i][temp1]){
    		        temp2=temp1;
    		        temp1=j;
    		    }
    		    else if(temp2==Integer.MAX_VALUE){
    		        temp2=j;
    		    }
    		    else if(dp[i][j]<=dp[i][temp2]){
    		        temp2=j;
    		    }
		    }
		    min1=temp1;
		    min2=temp2;
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<costs[0].length;i++){
		    ans=Math.min(ans,dp[costs.length-1][i]);
		}
		return ans;
	}
// 	public int helper(int[][] costs,int wall,int prev){
// 	    if(wall==costs.length){
// 	        return 0;
// 	    }
// 	    if(dp[wall][prev+1]!=-1){
// 	        return dp[wall][prev+1];
// 	    }
// 	    int ans=Integer.MAX_VALUE;
// 	    for(int i=0;i<costs[0].length;i++){
// 	        if(i==prev){
// 	            continue;
// 	        }
// 	        ans=Math.min(ans,costs[wall][i]+helper(costs,wall+1,i));
// 	   }
// 	    return dp[wall][prev+1]=ans;
// 	}
}