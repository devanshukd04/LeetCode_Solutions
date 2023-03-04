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
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long bestNode(int N, int[] A, int[] P) {
        // code here
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for(int i=1;i<=N;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int i=1;i<P.length;i++){
            map.get(P[i]).add(i+1);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            ans=Math.max(ans,helper(map,A,true,i));
        }
        return ans;
    }
    public static int helper(HashMap<Integer,List<Integer>> map,int[] A,boolean flag,int node){
        if(map.get(node).size()==0){
            return flag?A[node-1]:-A[node-1];
        }
        List<Integer> list=map.get(node);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(flag){
                ans=Math.max(ans,A[node-1]+helper(map,A,!flag,list.get(i)));
            }
            else{
                ans=Math.max(ans,-A[node-1]+helper(map,A,!flag,list.get(i)));
            }
        }
        return ans;
    }
}
        
