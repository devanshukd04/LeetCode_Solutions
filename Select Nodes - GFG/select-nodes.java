//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    int[] dp;
    public int countVertex(int N, int[][] edges){
        // code here
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=N;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[][] ans=new int[N+1][2];
        for(int i=1;i<=N;i++){
            ans[i][1]=1;
        }
        helper(map,1,1,ans);
        return Math.min(ans[1][0],ans[1][1]);
    }
    public void helper(HashMap<Integer,ArrayList<Integer>> map,int src,int par,int[][] val){
        for(Integer node:map.get(src)){
            if(node!=par){
                helper(map,node,src,val);
            }
        }
        for(Integer node:map.get(src)){
            if(node!=par){
                val[src][0]+=val[node][1];
                val[src][1]+=Math.min(val[node][1],val[node][0]);
            }
        }
    }
    
}

//{ Driver Code Starts.

// } Driver Code Ends