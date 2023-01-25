//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        // code here
        StringBuffer ans=new StringBuffer();
        int i=0;
        int moves=s.length();
        int curr=0;
        while(i<s.length()){
            if(ans.length()>1 && (i+ans.length())<=s.length()){
                String s1=ans.substring(0);
                String s2=s.substring(i,i+ans.length());
                if(s1.equals(s2)){
                    moves=Math.min(moves,i+1+(s.length()-i-s1.length()));
                }
            }
            else if(i+ans.length()>=s.length()){
                break;
            }
            ans.append(s.charAt(i));
            i++;
        }
        return moves;
    }
    public int helper(String s,int index,StringBuffer ans,boolean copy,int move){
        if(index>=s.length()){
            return 0;
        }
        int take=Integer.MAX_VALUE,notTake;
        
        if(copy && ans.length()>1 && (index+ans.length())<=s.length()){
            String s1=ans.substring(0);
            String s2=s.substring(index,index+ans.length());
            if(s1.equals(s2)){
                ans.append(s1);
                take=1+helper(s,index+s1.length(),ans,false,move+1);
                ans.delete(s1.length(),ans.length());
            }
        }
        ans.append(s.charAt(index));
        notTake=1+helper(s,index+1,ans,copy,move+1);
        return Math.min(take,notTake);
    }
}