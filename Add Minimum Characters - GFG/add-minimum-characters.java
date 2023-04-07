//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		StringBuilder orig=new StringBuilder(str);
		StringBuilder temp=new StringBuilder(str);
		String s=orig.append('#').append(temp.reverse()).toString();
		int n=s.length();
		int[] arr=LPS(s);
		return str.length()-arr[n-1];
		
	}
	public static int[] LPS(String s){
	    int n=s.length();
	    int[] lps=new int[n];
	    int i=1,len=0;
	    lps[0]=0;
	    while(i<n){
	        if(s.charAt(i)==s.charAt(len)){
	            len++;
	            lps[i]=len;
	            i++;
	        }
	        else{
	            if(len==0){
	                lps[i]=0;
	                i++;
	            }
	            else{
	                len=lps[len-1];
	            }
	        }
	    }
	    return lps;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends