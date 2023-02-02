//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long ans=-1;
    public long largesSumCycle(int N, int Edge[]){
        int[] visited=new int[N+1];
        for(int i=0;i<N;i++){
            if(visited[i+1]==1){
                continue;
            }
            helper(Edge,i,new HashSet<Integer>(),new ArrayList<Integer>(),0,visited);   
        }
        return ans;
    }
    public void helper(int[] Edge,int node,HashSet<Integer> set,List<Integer> list,long sum,int[] visited){
        if(node==-1){
            return;
        }   
        if(set.contains(Edge[node])){
            int temp=0;
            long tempSum=0;
            for(int i=0;i<list.size();i++){
                if(Edge[node]==list.get(i)){
                    temp=i;
                    break;
                }
                tempSum+=list.get(i);
            }
            ans=Math.max(ans,sum-tempSum);
            return;
        }
        else{
            if(visited[Edge[node]+1]==1){
                return;
            }
            visited[Edge[node]+1]=1;
            list.add(Edge[node]);
            set.add(Edge[node]);
            helper(Edge,Edge[node],set,list,sum+Edge[node],visited);
            set.remove(Edge[node]);
            list.remove(list.size()-1);
        }
    }
}