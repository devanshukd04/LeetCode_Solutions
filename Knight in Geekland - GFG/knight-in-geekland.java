//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int a,b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        // Code Here.
        int r=arr.length;
        int c=arr[0].length;
        int[] dx={-2,-1,1,2,2,1,-1,-2};
        int[] dy={1,2,2,1,-1,-2,-2,-1};
        boolean[][] visited=new boolean[r][c];
        List<Integer> a1=new ArrayList<Integer>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(start_x,start_y));
        visited[start_x][start_y]=true;
        while(!q.isEmpty()){
            int size=q.size();
            int curr_lev_pts=0;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int x=curr.a;
                int y=curr.b;
                curr_lev_pts+=arr[x][y];
                for(int j=0;j<8;j++){
                    int n_x=x+dx[j];
                    int n_y=y+dy[j];
                    if(is_Safe(n_x,n_y,r,c) && !visited[n_x][n_y]){
                        visited[n_x][n_y]=true;
                        q.add(new Pair(n_x,n_y));
                    }
                }
            }
            a1.add(curr_lev_pts);
        }
        int max=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=a1.size()-1;i>=0;i--){
            if(a1.get(i)+i<a1.size()){
                a1.set(i,a1.get(i)+a1.get(i+a1.get(i)));
            }
        }
        for(int i=0;i<a1.size();i++){
            if(a1.get(i)>max){
                max=a1.get(i);
                ans=i;
            }
        }
        return ans;
    }
    boolean is_Safe(int i,int j,int r,int c){
        if(i<0 || i>=r || j<0 || j>=c){
            return false;
        }
        return true;
    }
}   
