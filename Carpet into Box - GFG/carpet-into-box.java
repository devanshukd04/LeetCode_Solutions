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
        int a1=binaryShift(A,C);
        int a2=binaryShift(A,D);
        int b1=binaryShift(B,C);
        int b2=binaryShift(B,D);
        return Math.min(a1+b2,a2+b1);
    }
    public static int binaryShift(int temp,int a){
        int ans=0;
        while(temp>a){
            temp>>=1;
            ans++;
        }
        return ans;
    }
}
