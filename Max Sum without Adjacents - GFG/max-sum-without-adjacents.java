//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,dp,0);
    }
    public int helper(int[] arr,int[] dp,int index){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        //take
        int take=arr[index]+helper(arr,dp,index+2);
        //notTake
        int notTake=helper(arr,dp,index+1);
        return dp[index]=Math.max(take,notTake);
    }
}