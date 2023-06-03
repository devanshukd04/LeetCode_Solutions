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
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int index1=0;
        int index2=0;
        int index3=0;
        int[] arr=new int[3];
        for(int num:S1){
            arr[0]+=num;
        }
        for(int num:S2){
            arr[1]+=num;
        }
        for(int num:S3){
            arr[2]+=num;
        }
        while(index1!=N1 && index2!=N2 && index3!=N3){
            if(arr[0]==arr[1] && arr[1]==arr[2]){
                return arr[0];
            }
            if(arr[0]>=arr[1] && arr[0]>=arr[2]){
                arr[0]-=S1[index1++];
            }
            else if(arr[1]>=arr[0] && arr[1]>=arr[2]){
                arr[1]-=S2[index2++];
            }
            else{
                arr[2]-=S3[index3++];
            }
        }
        return 0;
    }
}
        
