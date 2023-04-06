//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			System.out.println(ob.equalSum(A, N));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		int[] prefix=new int[N];
		prefix[0]=0;
	    for(int i=1;i<N;i++){
	        prefix[i]=prefix[i-1]+A[i-1];
	    }
	    int total=prefix[N-1]+A[N-1];
	    for(int i=0;i<N;i++){
	        if(prefix[i]==(total-prefix[i]-A[i])){
	            return i+1;
	        }
	    }
	    return -1;
	}
}