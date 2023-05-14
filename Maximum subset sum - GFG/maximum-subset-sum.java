//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        Long[][] dp=new Long[A.length][2];
        return helper(A,dp,0,1);
    }
    public static long helper(int[] A,Long[][] dp,int index,int prev){
        if(index>=A.length){
            return 0;
        }
        if(dp[index][prev]!=null){
            return dp[index][prev];
        }
        long take=Integer.MIN_VALUE;
        long notTake=Integer.MIN_VALUE;
        if(prev==1){
            notTake=helper(A,dp,index+1,0);
        }
        take=A[index]+helper(A,dp,index+1,1);
        return dp[index][prev]=Math.max(take,notTake);
    }
}
        
