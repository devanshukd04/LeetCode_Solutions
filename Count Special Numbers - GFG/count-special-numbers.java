//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt(); // Inputting the testcases
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {

            int i = 0;
            int N = sc.nextInt();

            int arr[] = new int[(int)(N)];

            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(N, arr));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        int ans=0;
        Arrays.sort(arr);
        int max=arr[N-1];
        HashSet<Integer> set=new HashSet<Integer>();
        HashSet<Integer> visited=new HashSet<Integer>();
        for(int num:arr){
            if(set.contains(num)){
                visited.add(num);
            }
            set.add(num);
        }
        set.clear();
        //System.out.println(ans+" "+Arrays.toString(arr));
        for(int i=0;i<N;i++){
            if(set.contains(arr[i])){
                ans++;       
            }
            else{
                int element=arr[i];
                if(visited.contains(arr[i])){
                    ans++;
                    visited.remove(arr[i]);
                }
                for(int j=element;j<=max;j+=element){
                    set.add(j);
                }
            }
        }
        return ans;
    }
}