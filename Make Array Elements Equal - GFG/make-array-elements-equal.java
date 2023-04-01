//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        // Code here
        int target=0;
        if(N%2==0){
            target=((N-1)/2)*2+2;
        }
        else{
            target=((N)/2)*2+1;
        }
        int n=N/2;
        long ans=((long)n*(long)(2*(long)(target-1)+(long)(n-1)*(long)(-2)))/(long)2;
        return ans;
    }
}