//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        StringBuffer s=new StringBuffer(S);
        int[] freq=new int[26];
        for(int i=0;i<S.length();i++){
            freq[S.charAt(i)-'a']++;
        }
        boolean swap=true;
        boolean flag=true;
        int start=0;
        int end=S.length()-1;
        while(flag){
            flag=false;
            int index;
            if(swap){
                index=start;
                while(index<s.length()){
                    char ch=s.charAt(index);
                    if(ch!='#' && freq[ch-'a']>1){
                        flag=true;
                        s.replace(index,index+1,"#");
                        freq[ch-'a']--;
                        break;
                    }
                    index++;
                    start=index+1;
                }   
            }
            else{
                index=end;
                while(index>=0){
                    char ch=s.charAt(index);
                    if(ch!='#' && freq[ch-'a']>1){
                        flag=true;
                        s.replace(index,index+1,"#");
                        freq[ch-'a']--;
                        break;
                    }
                    index--;
                    end=index-1;
                }   
            }
            swap=!swap;
        }
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                ans.append(s.charAt(i));
            }
        }
        if(swap){
            ans.reverse();
        }
        return ans.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends