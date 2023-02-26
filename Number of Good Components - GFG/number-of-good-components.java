//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int connected=0;
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited=new int[V+1];
        List<Integer> list=new ArrayList<Integer>();
        int ans=0;
        for(int i=1;i<=V;i++){
            if(visited[i]!=1){
                connected=0;
                if(helper(adj,visited,i,adj.get(i).size()) && connected==(adj.get(i).size()+1)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean helper(ArrayList<ArrayList<Integer>> adj,int[] visited,int vertex,int size){
        if(visited[vertex]==1){
            return true;
        }
        visited[vertex]=1;
        connected++;
        List<Integer> list1=adj.get(vertex);
        boolean ans=true;
        for(int i=0;i<list1.size();i++){
            ans&=helper(adj,visited,list1.get(i),size);
        }
        if(list1.size()!=size){
            return false;
        }
        return ans;
    }
}