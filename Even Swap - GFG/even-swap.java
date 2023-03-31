//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		int i=0;
		int[] ans=new int[arr.length];
		List<Integer> list=new ArrayList<Integer>();
		while(i<arr.length){
		    int j=i+1;
		    list.add(arr[i]);
		    while(j<arr.length && arr[i]%2==arr[j]%2){
		        list.add(arr[j]);
		        j++;
		    }
		    Collections.sort(list);
		    int index=i;
		    for(int k=list.size()-1;k>=0;k--){
		        ans[index++]=list.get(k);
		    }
		    list.clear();
		    i=j;
		}
		return ans;
	}
}