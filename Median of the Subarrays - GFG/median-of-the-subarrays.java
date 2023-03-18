//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countSubarray(int N, int A[], int M) 
    {
        // code here
        return solve(N,A,M)-solve(N,A,M+1);
    }
    public long solve(int N,int[] A,int M){
        int[] arr=new int[2*N+1];
        Arrays.fill(arr,0);
        long curr=N;
        long total=0;
        long ans=0;
        arr[(int)curr]++;
        for(int i=0;i<N;i++){
            int x=-1;
            if(A[i]>=M){
                x=1;
            }
            if(x==-1){
                total-=arr[(int)(curr+x)];
            }
            else{
                total+=arr[(int)curr];
            }
            curr+=x;
            ans+=total;
            arr[(int)curr]++;
        }
        return ans;
    }
} 