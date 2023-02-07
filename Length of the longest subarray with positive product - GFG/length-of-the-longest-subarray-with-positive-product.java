//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int prev=1;
            int j=i;
            int firstNeg=-1;
            int lastNeg=-1;
            int firstPos=-1;
            int lastPos=-1;
            while(j<arr.length){
                int temp=arr[j]==0?0:(arr[j]<0?-1:1);
                prev*=temp;
                if(prev==0){
                    break;
                }
                else if(prev==1){
                    if(firstPos==-1){
                        firstPos=j;
                        lastPos=j;
                    }
                    else{
                        lastPos=j;
                    }
                }
                else{
                    if(firstNeg==-1){
                        firstNeg=j;
                        lastNeg=j;
                    }
                    else{
                        lastNeg=j;
                    }
                }
                j++;
            }
            i=j;
            if(lastNeg!=-1){
                ans=(lastNeg-firstNeg)<ans?ans:(lastNeg-firstNeg);   
            }
            if(lastPos!=-1){
                ans=(lastPos-firstPos+1)<ans?ans:(lastPos-firstPos+1);   
            }
            if(firstNeg!=-1 && lastPos!=-1){
                ans=(lastPos-firstNeg+1)<ans?ans:(lastPos-firstNeg+1);   
            }
        }
        return ans;
    }
}