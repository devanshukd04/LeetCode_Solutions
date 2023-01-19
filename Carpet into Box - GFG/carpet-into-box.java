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
        int a1=0;
        int a2=0;
        int b1=0;
        int b2=0;
        int temp;
        temp=A;
        while(temp>C){
            temp>>=1;
            a1++;
        }
        temp=A;
        while(temp>D){
            temp>>=1;
            a2++;
        }
        temp=B;
        while(temp>C){
            temp>>=1;
            b1++;
        }
        temp=B;
        while(temp>D){
            temp>>=1;
            b2++;
        }
        return Math.min(a1+b2,a2+b1);
    }
   
}
