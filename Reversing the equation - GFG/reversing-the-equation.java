//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<S.length();i++){
            int start=i;
            int end=i;
            while(end!=S.length()){
                if(S.charAt(end)=='+'|| S.charAt(end)=='-'|| S.charAt(end)=='*' || S.charAt(end)=='/'){
                    break;
                }
                end++;
            }
            end-=1;
            if(end==(start-1)){
                end++;
            }
            int temp=end;
            while(end>=start){
                stack.push(S.charAt(end));
                end--;
            }
            i=temp;
        }
        StringBuffer ans=new StringBuffer();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}