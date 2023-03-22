//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
	    String s1="pr";
	    String s2="rp";
	    if(X<Y){
	        int temp=X;
	        X=Y;
	        Y=temp;
	        String t=s1;
	        s1=s2;
	        s2=t;
	    }
	    long ans=0;
	    Stack<Character> stack=new Stack<Character>();
	    for(int i=S.length()-1;i>=0;i--){
	        Character curr=S.charAt(i);
	        Character first=s1.charAt(0);
	        Character second=s1.charAt(1);
	        if(stack.size()>0 && curr==first && stack.peek()==second){
	            stack.pop();
	            ans+=X;
	        }
	        else{
	            stack.push(curr);
	        }
	    }
	    StringBuilder rem=new StringBuilder();
	    S=rem.toString();
	    while(stack.size()>0){
	        rem.append(stack.pop());
	    }
	    S=rem.toString();
	    for(int i=S.length()-1;i>=0;i--){
	        Character curr=S.charAt(i);
	        Character first=s2.charAt(0);
	        Character second=s2.charAt(1);
	        if(stack.size()>0 && curr==first && stack.peek()==second){
	            stack.pop();
	            ans+=Y;
	        }
	        else{
	            stack.push(curr);
	        }
	    }
        return ans;
	}
} 
