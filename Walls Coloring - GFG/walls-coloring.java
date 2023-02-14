//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int[][] dp=new int[colors.length][4];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(colors,dp,0,-1);
    }
    public int helper(int[][] colors,int[][] dp,int wallNo,int color){
        if(wallNo==colors.length){
            return 0;
        }
        if(dp[wallNo][color+1]!=-1){
            return dp[wallNo][color+1];
        }
        int totalCost=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(i!=color){
                totalCost=Math.min(totalCost,colors[wallNo][i]+helper(colors,dp,wallNo+1,i));
            }
        }
        dp[wallNo][color+1]=totalCost;
        return totalCost;
    }
}