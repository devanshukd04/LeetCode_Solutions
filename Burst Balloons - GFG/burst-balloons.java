//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int maxCoins(int N, int[] arr) {
        int[][] dp=new int[arr.length+1][arr.length+1];
        for(int[] array:dp){
            Arrays.fill(array,-1);
        }
        return helper(arr,0,arr.length-1,dp);
    }
    public static int helper(int[] nums,int left,int right,int[][] dp){
        if(left>right){
            return 0;
        }
        int sum=0;
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        for(int i=left;i<=right;i++){
            int value=nums[i];
            int add=value*((left>0)?nums[left-1]:1)*((right<nums.length-1)?nums[right+1]:1);
            sum=Math.max(sum,helper(nums,left,i-1,dp)+helper(nums,i+1,right,dp)+add);
        }
        dp[left][right]=sum;
        return sum;
    }
}
     