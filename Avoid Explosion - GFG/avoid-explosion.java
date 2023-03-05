//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] parent;
    int[] rank;
    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
        // Code Here
        ArrayList<String> ans=new ArrayList<>();
        this.parent=new int[n+1];
        this.rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            int a=find(mix[i][0]);
            int b=find(mix[i][1]);
            boolean flag=true;
            for(int j=0;j<m;j++){
                int c=find(danger[j][0]);
                int d=find(danger[j][1]);
                if((a==c && b==d) || (a==d && b==c)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                union(a,b);
                ans.add("Yes");
            }
            else{
                ans.add("No");
            }
        }
        return ans;
    }
    void union(int x,int y){
        int x1=find(x);
        int y1=find(y);
        if(x1==y1){
            return;
        }
        else if(rank[x1]<rank[y1]){
            parent[x1]=y1;
        }
        else if(rank[x1]>rank[y1]){
            parent[y1]=x1;
        }
        else{
            parent[y1]=x1;
            rank[x1]++;
        }
    }
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}
