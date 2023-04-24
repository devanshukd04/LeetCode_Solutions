//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int[] left=new int[arr.length];
		int[] right=new int[arr.length];
		Stack<Integer> stack=new Stack<>();
		for(int i=arr.length-1;i>=0;i--){
		    if(stack.isEmpty()){
		        right[i]=-1;
		    }
		    else{
		        while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
		            stack.pop();
		        }
		        if(stack.isEmpty()){
		            right[i]=-1;
		        }
		        else{
		            right[i]=stack.peek();
		        }
		    }
		    stack.push(i);
		}
		stack.clear();
		for(int i=0;i<arr.length;i++){
		    if(stack.isEmpty()){
		        left[i]=-1;
		    }
		    else{
		        while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
		            stack.pop();
		        }
		        if(stack.isEmpty()){
		            left[i]=-1;
		        }
		        else{
		            left[i]=stack.peek();
		        }
		    }
		    stack.push(i);
		}
		int[] ans=new int[arr.length];
		for(int i=0;i<arr.length;i++){
		    if(left[i]==-1){
		        ans[i]=right[i];
		    }
		    else if(right[i]==-1){
		        ans[i]=left[i];
		    }
		    else{
		        int leftDist=i-left[i];
		        int rightDist=right[i]-i;
		        if(leftDist==rightDist){
		            if(arr[left[i]]>arr[right[i]]){
		                ans[i]=right[i];
		            }
		            else{
		                ans[i]=left[i];
		            }
		        }
		        else if(leftDist>rightDist){
		            ans[i]=right[i];
		        }
		        else{
		            ans[i]=left[i];
		        }
		    }
		}
		return ans;
	}
}