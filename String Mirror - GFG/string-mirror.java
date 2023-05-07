//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        String ans="";
        int prev=26;
        for(int i=0;i<str.length();i++){
            int curr=str.charAt(i)-'a';
            if(curr<prev || (curr<=prev && curr!=(str.charAt(0)-'a'))){
                ans=str.substring(0,i+1);
                prev=curr;
            }
            else{
                break;
            }
        }
        StringBuilder temp=new StringBuilder(ans);
        temp.reverse();
        ans+=temp.toString();
        return ans;
    }
}
        
