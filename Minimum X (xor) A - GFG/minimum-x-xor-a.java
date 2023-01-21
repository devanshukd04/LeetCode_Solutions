//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int setBit=0;
        int temp=b;
        while(temp>0){
            if((temp&1)==1){
                setBit++;
            }
            temp>>=1;
        }
        int size=0;
        temp=a;
        List<Integer> list=new ArrayList<Integer>();
        int val=1;
        while(temp>0){
            if((temp&1)==1){
                list.add(val);
            }
            val*=2;
            temp>>=1;
        }
        int ans=0;
        for(int i=list.size()-1;i>=0;i--){
            ans+=list.get(i);
            setBit--;
            if(setBit==0){
                break;
            }
        }
        int index=0;
        val=1;
        while(setBit>0){
            if(index==list.size() || list.get(index)!=val){
                ans+=val;
                setBit--;
            }
            else if(index!=list.size()){
                index++;
            }
            val*=2;
        }
        return ans;
    }
}