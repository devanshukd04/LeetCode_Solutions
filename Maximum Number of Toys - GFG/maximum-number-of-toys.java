//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            int N = sc.nextInt();
            int A[] = new int[N];
            for(int i = 0; i < N; i++) A[i] = sc.nextInt();
            int Q = sc.nextInt();
            ArrayList<Integer> Queries[] = new ArrayList[Q];
            for(int i = 0; i < Q; i++){
                Queries[i] = new ArrayList<>();
                int x = sc.nextInt(), y = sc.nextInt();
                Queries[i].add(x);
                Queries[i].add(y);
                for(int j = 0; j < Queries[i].get(1); j++){
                    x = sc.nextInt();
                    Queries[i].add(x);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumToys(N, A, Q, Queries);
            for(int x : ans)
                out.print(x + " ");
            out.print("\n");
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fr[];
    final class FenwickTree{
        final int N;
        final long bit[];
        FenwickTree(int N){
            this.N=N;
            this.bit=new long[N];
        }
        void add(int node,int v){
            for(;node<N;node+=(node&(-node))){
                bit[node]+=v;
            }
        }
        long get(int node){
            long x=0l;
            for(;node>0;node-=(node&(-node))){
                x+=bit[node];
            }
            return x;
        }
    }
    ArrayList<Integer> maximumToys(int N, int A[], int Q, ArrayList<Integer> Queries[]){
        fr=new int[1000005];
        for(int x:A){
            fr[x]++;
        }
        FenwickTree obj1=new FenwickTree(1000005);
        FenwickTree obj2=new FenwickTree(1000005);
        for(int i=0;i<N;i++){
            obj1.add(A[i],A[i]);
            obj2.add(A[i],1);
        }
        final ArrayList<Integer> ans=new ArrayList<Integer>();
        for(ArrayList<Integer> query:Queries){
            long C=query.get(0);
            for(int j=2;j<query.size();j++){
                obj1.add(A[query.get(j)-1],-A[query.get(j)-1]);
                obj2.add(A[query.get(j)-1],-1);
            }
            int low=1;
            int high=1000000,pos=1000000;
            while(low<=high){
                int mid=(low+high)>>1;
                if(obj1.get(mid)>=C){
                    pos=mid;
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            long res=obj2.get(pos-1);
            long max=Math.min((C-obj1.get(pos-1))/pos,(long)fr[pos]);
            ans.add((int)(res+max));
            for(int j=2;j<query.size();j++){
                obj1.add(A[query.get(j)-1],A[query.get(j)-1]);
                obj2.add(A[query.get(j)-1],1);
            }
        }
        return ans;
    }
}