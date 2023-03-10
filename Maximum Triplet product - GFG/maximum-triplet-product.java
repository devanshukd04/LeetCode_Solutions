//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {   
        Long min1=null;
        Long min2=null;
        Long max1=null;
        Long max2=null;
        Long max3=null;
        for(long num:arr){
            if(min1==null){
                min1=num;
            }
            else if(min1>=num){
                min2=min1;
                min1=num;
            }
            else if(min2==null){
                min2=num;
            }
            else if(min2>=num){
                min2=num;
            }
            
            if(max1==null){
                max1=num;
            }
            else if(max1<=num){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(max2==null){
                max2=num;
            }
            else if(max2<=num){
                max3=max2;
                max2=num;
            }
            else if(max3==null){
                max3=num;
            }
            else if(max3<=num){
                max3=num;
            }   
        }
        return Math.max((min1*min2*max1),(max1*max2*max3));
        // Complete the function
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends