//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int x1=0;
        int x2=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int prev=binarySearchPrev(brr,x-arr[i]);
            int next=binarySearchNext(brr,x-arr[i]);
            
            if(prev!=-1 && Math.abs(x-arr[i]-prev)<min){
                min=Math.abs(x-arr[i]-prev);
                x1=arr[i];
                x2=prev;
            }
            if(next!=-1 && Math.abs(x-arr[i]-next)<min){
                min=Math.abs(x-arr[i]-next);
                x1=arr[i];
                x2=next;
            }
        }
        ans.add(x1);
        ans.add(x2);
        return ans;
    }
    public static int binarySearchPrev(int[] brr, int target){
        int i=0;
        int j=brr.length-1;
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(brr[mid]==target){
                return brr[mid];
            }
            else if(brr[mid]<target){
                ans=brr[mid];
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;    
    }
    public static int binarySearchNext(int[] brr, int target){
        int i=0;
        int j=brr.length-1;
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(brr[mid]==target){
                return brr[mid];
            }
            else if(brr[mid]<target){
                i=mid+1;
            }
            else{
                ans=brr[mid];
                j=mid-1;
            }
        }
        return ans;    
    }
}