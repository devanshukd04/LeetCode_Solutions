//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+B[i]);
        }
        for(int key:map.keySet()){
            int temp=map.get(key);
            if(temp/2>0){
                map1.put(key,temp/2);
            }
        }
        int[][] array=new int[map1.size()][2];
        int index=0;
        for(int key:map1.keySet()){
            array[index][0]=key;
            array[index++][1]=map1.get(key);
        }
        Arrays.sort(array,(a,b)->(a[0]==b[0])?(b[1]-a[1]):(b[0]-a[0]));
        int carry=0;
        long ans=0;
        for(int[] arr:array){
            int temp=arr[1];
            ans+=arr[0]*4*(temp/2);
            if(carry!=0 && temp%2==1){
                ans+=carry+arr[0]*2;
                carry=0;
            }
            else if(carry!=0){
                ans+=carry;
                ans-=arr[0]*2;
                carry=arr[0]*2;
            }
            else if(temp%2==1){
                carry=arr[0]*2;
            }
        }
        return (long)ans;
    }
} 