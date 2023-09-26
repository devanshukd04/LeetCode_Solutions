//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int l=j+1;l<arr.length;l++){
                    int req=k-(arr[i]+arr[j]+arr[l]);
                    if(map.containsKey(req) && map.get(req)>l){
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(req);
                        if(!set.contains(list)){
                            ans.add(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}