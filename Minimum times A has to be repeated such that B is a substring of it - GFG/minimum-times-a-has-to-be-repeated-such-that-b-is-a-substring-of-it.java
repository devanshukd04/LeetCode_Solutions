//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int index=-1;
        for(int i=0;i<B.length();i++){
            int size=Math.min(A.length(),B.length()-i);
            String a=A.substring(0,size);
            String b=B.substring(i,i+size);
            if(a.equals(b)){
                index=i;
                break;
            }
        }
        if(index==-1){
            return -1;
        }
        if(index>=A.length()){
            return -1;
        }
        int ans=0;
        if(index!=0 && A.substring(A.length()-index,A.length()).equals(B.substring(0,index))){
            ans=1;
        }
        else if(index!=0){
            return -1;
        }
        ans+=1;
        int j=index;
        index=0;
        for(int i=j;i<B.length();i++){
            if(index>=A.length()){
                index=0;
                ans++;
            }
            if(A.charAt(index++)!=B.charAt(i)){
                return -1;
            }
        }
        return ans;
    }
};