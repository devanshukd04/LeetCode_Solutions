//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	long maximizeMinHeight(int n, int k, int w,int [] a)
    {
        //Write your code here
        long ans=0;
        long start=0;
        long end=(int)1e10;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(isValid(a,n,k,w,mid)){
                start=mid+1;
                ans=mid;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    boolean isValid(int[] a,int n,int k,int w,long mid){
        long[] ps=new long[n];
        long ans=0;
        for(int i=0;i<n;i++){
            if(i>=1){
                ps[i]+=ps[i-1];
            }
            if(a[i]+ps[i]<mid){
                long e=mid-a[i]-ps[i];
                ans+=e;
                ps[i]+=e;
                if((i+w)<n){
                    ps[i+w]-=e;
                }
            }
        }
        return ans<=k;
    }
}