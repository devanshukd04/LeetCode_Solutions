//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int dollar5 = 0;
        int dollar10 = 0;
        int dollar20 = 0;
        
        for(int i=0; i<N; i++){
            if(bills[i]==5){
                dollar5++;
            }
            else if(bills[i]==10){
                if(dollar5<=0){
                    return false;
                }
                else {
                    dollar10++;
                    dollar5--;
                }
            }
            else if(bills[i]==20){
                dollar20++;
                
                if((dollar5>0) && (dollar10>0)){
                    dollar5--;
                    dollar10--;
                }
                else if(dollar5>=3){
                    dollar5 = dollar5 - 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
