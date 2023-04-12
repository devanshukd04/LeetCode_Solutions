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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dominantPairs(int n, int[] arr) {
        // code here
        int ans=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length/2;i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        for(int i=0;i<arr.length/2;i++){
            arr[i]=list.get(i);
        }
        list.clear();
        for(int i=arr.length/2;i<arr.length;i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        for(int i=arr.length/2;i<arr.length;i++){
            arr[i]=list.get(i-arr.length/2);
        }
        int start=0;
        int end=arr.length/2;
        while(start<arr.length/2){
            while(end<arr.length && arr[start]>=5*arr[end]){
                end++;
            }
            start++;
            ans+=end-arr.length/2;
        }
        return ans;
    }
}
        
