//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        int ans=-1;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<P.length;i++){
            if(!map.containsKey(P[i])){
                map.put(P[i],i);
            }
        }
        for(int i=0;i<S.length()-1;i++){
            if(S.charAt(i)==S.charAt(i+1)){
                int j=i;
                while(j<S.length()-1 && S.charAt(j)==S.charAt(j+1)){
                    j+=1;
                }
                ans=Math.max(ans,helper(i,j,map));
            }       
        }
        return ans+1;
    }
    public static int helper(int i,int j,HashMap<Integer,Integer> map){
        int ans=Integer.MIN_VALUE;
        int temp1=-1;
        for(int k=i;k<=j;k+=2){
            temp1=Math.max(temp1,map.get(k));
        }
        int temp2=-1;
        for(int k=i+1;k<=j;k+=2){
            temp2=Math.max(temp2,map.get(k));
        }
        ans=temp1<temp2?temp1:temp2;
        return ans;
    }
}
        
