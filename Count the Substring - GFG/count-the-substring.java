//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long countSubstring(String S){
        long ans=0;
        int n=S.length();
        long[] dp=new long[2*n+1];
        int count=n;
        int sub=0;
        for(int i=0;i<n;i++){
            count=S.charAt(i)=='0'?(count-1):(count+1);
            if(count<=n){
                sub++;
            }
            dp[count]++;
        }
        int index=n;
        for(int i=0;i<S.length();i++){
            ans+=(n-i-sub);
            if(S.charAt(i)=='0'){
                sub--;
                sub-=dp[index--];
                dp[index]--;
            }
            else{
                dp[++index]--;
                sub+=dp[index];
            }
        }
       return ans;
    }
}