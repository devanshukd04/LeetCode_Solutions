//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
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
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
        // code here
        if(a==0 && b==0 && c==0){
            return 0;
        }
        else if((a==0 && b==0) || (b==0 && c==0) || (a==0 && c==0)){
            return -1;
        }
        if(a>=b && a>=c){
            int temp=a/2+(a%2==0?-1:0);
            if((b+c)<temp){
                return -1;
            }
            return a+b+c;
        }
        else if(b>=a && b>=c){
            int temp=b/2+(b%2==0?-1:0);
            if((a+c)<temp){
                return -1;
            }
            return a+b+c;
        }
        else{
            int temp=c/2+(c%2==0?-1:0);
            if((a+b)<temp){
                return -1;
            }
            return a+b+c;
        }
    }
};