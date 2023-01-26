//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        int index1=0;
        int index2=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch<='Z'){
                index2++;
            }
            else{
                index1++;
            }
        }
        char[] lower=new char[index1];
        char[] upper=new char[index2];
        index1=0;
        index2=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch<='Z'){
                upper[index2++]=str.charAt(i);
            }
            else{
                lower[index1++]=str.charAt(i);
            }
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        index1=0;
        index2=0;
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<='Z'){
                ans.append(upper[index2++]);   
            }
            else{
                ans.append(lower[index1++]);
            }
        }
        return ans.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends