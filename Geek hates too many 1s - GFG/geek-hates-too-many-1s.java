//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        List<Integer> list=new ArrayList<Integer>();
        while(n>0){
            list.add(n&1);
            n>>=1;
        }
        boolean flag=false;
        boolean flag1=false;
        int ans=0;
        for(int i=list.size()-1;i>=0;i--){
            int bit=list.get(i);
            if(!flag1 && !flag && bit==1){
                flag=true;
            }
            else if(!flag1 && flag && bit==1){
                flag1=true;
            }
            else if(flag1 && flag && bit==1){
                flag=false;
                flag1=false;
                bit=0;
            }
            else{
                flag=false;
                flag1=false;
            }
            ans<<=1;
            ans|=bit;
        }
        return ans;
    }
}
        
