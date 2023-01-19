//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int a1=binaryShift(A,B,C,D);
        int a2=binaryShift(B,A,C,D);
        return Math.min(a1,a2);
    }
    public static int binaryShift(int temp1,int temp2,int a,int b){
        int ans=0;
        while(temp1>a || temp2>b){
            if(temp1>a){
                temp1>>=1;
            }
            else{
                temp2>>=1;
            }
            ans++;
        }
        return ans;
    }
}
