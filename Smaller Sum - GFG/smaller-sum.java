//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        HashMap<Integer,Long> map=new HashMap<>();
        int[] arr1=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr1[i]=arr[i];
        }
        Arrays.sort(arr);
        long[] ans=new long[arr.length];
        long[] prefixSum=new long[arr.length];
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j<arr.length && arr[j]==arr[i]){
                ans[j]=prefixSum[i]-arr[i];
                j++;
            }
            map.put(arr[i],prefixSum[i]-arr[i]);
            i=--j;
        }
        for(int i=0;i<arr1.length;i++){
            ans[i]=map.get(arr1[i]);
        }
        return ans;
    }
}