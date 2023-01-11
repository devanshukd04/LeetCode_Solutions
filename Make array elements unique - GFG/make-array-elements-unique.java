//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        Arrays.sort(arr);
        HashSet<Integer> set=new HashSet<Integer>();
        List<Integer> list=new ArrayList<Integer>();
        int index=0;
        int prev=arr[0]+1;
        long ans=0;
        for(int i=0;i<N;i++){
            if(set.contains(arr[i])){
                list.add(arr[i]);
            }
            else{
                set.add(arr[i]);   
            }
            while(index<list.size() && prev<arr[i]){
                ans+=(prev-list.get(index));
                index++;
                prev++;
            }
            prev=arr[i]+1;
        }
        while(index<list.size()){
            ans+=(prev-list.get(index));
            index++;
            prev++;
        }
        return ans;
    }
}