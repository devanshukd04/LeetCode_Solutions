//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[][] dp=new int[n+1][n+1];
	    
	    for(int[] dpArr:dp){
	        Arrays.fill(dpArr,-1);
	    }
	    
	    return helper(dp,arr,0,-1);
	}  
	public int helper(int[][] dp, int[] arr, int currIndex, int prevIndex){
	    if(currIndex==arr.length){
	        return 0;
	    }
	    
	    if(dp[currIndex+1][prevIndex+1]!=-1){
	        return dp[currIndex+1][prevIndex+1];
	    }
	    
	    int take=0;
	    int notTake=helper(dp,arr,currIndex+1,prevIndex);
	    if(prevIndex==-1 || arr[prevIndex]<arr[currIndex]){
	        take=arr[currIndex]+helper(dp,arr,currIndex+1,currIndex);
	    }
	    return dp[currIndex+1][prevIndex+1]=Math.max(take,notTake);
	}
}