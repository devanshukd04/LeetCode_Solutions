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
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		int ans=0;
		if(mat.length==0 || mat[0].length==0){
		    return 0;
		}
		int row=mat.length;
		int col=mat[0].length;
		int[][] visited1=new int[row][col];
		int[][] visited2=new int[row][col];
		for(int i=0;i<row;i++){
		    dfs(mat,visited1,i,0,Integer.MIN_VALUE);
		    dfs(mat,visited2,i,col-1,Integer.MIN_VALUE);
		}
		for(int i=0;i<col;i++){
		    dfs(mat,visited1,0,i,Integer.MIN_VALUE);
		    dfs(mat,visited2,row-1,i,Integer.MIN_VALUE);
		}
		for(int i=0;i<row;i++){
		    for(int j=0;j<col;j++){
		        if(visited1[i][j]==1 && visited2[i][j]==1){
		            ans++;
		        }
		    }
		}
		return ans;
	}
	public void dfs(int[][] mat,int[][] visited,int i,int j,int prev){
	    if(i<0 || i>=mat.length || j<0 ||  j>=mat[0].length){
	        return;
	    }
	    if(mat[i][j]<prev || visited[i][j]==1){
	        return;
	    }
	    visited[i][j]=1;
	    dfs(mat,visited,i+1,j,mat[i][j]);
	    dfs(mat,visited,i-1,j,mat[i][j]);
	    dfs(mat,visited,i,j+1,mat[i][j]);
	    dfs(mat,visited,i,j-1,mat[i][j]);
	}
}