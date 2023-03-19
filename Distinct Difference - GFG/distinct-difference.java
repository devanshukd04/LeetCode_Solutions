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
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        HashSet<Integer> set=new HashSet<Integer>();
        int[] arrLeft=new int[A.length];
        int[] arrRight=new int[A.length];
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            arrLeft[i]=set.size();
            set.add(A[i]);
        }
        set.clear();
        for(int i=N-1;i>=0;i--){
            arrRight[i]=set.size();
            set.add(A[i]);
        }
        for(int i=0;i<N;i++){
            ans.add(arrLeft[i]-arrRight[i]);
        }
        return ans;
    }
}
        
