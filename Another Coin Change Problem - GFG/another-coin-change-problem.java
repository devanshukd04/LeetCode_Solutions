//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        Arrays.sort(coins);
        int[][] dp=new int[target+1][K+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(coins,dp,K,target,0);
    }
    public static boolean helper(int[] coins,int[][] dp,int k,int target,int index){
        if(target==0 && k==0){
            return true;
        }
        if(index>=coins.length || target==0){
            return false;
        }
        if(dp[target][k]!=-1){
            return dp[target][k]==1?true:false;
        }
        boolean ans=false;
        int index1=index;
        while(index1<coins.length && coins[index1]==coins[index]){
            index1++;
        }
        for(int i=0;i<=k && coins[index]*i<=(target);i++){
            if(helper(coins,dp,k-i,target-coins[index]*i,index1)){
                dp[target][k]=1;
                return true;
            }
        }
        dp[target][k]=0;
        return false;
    }
}
