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
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        int[] visited=new int[A.length];
        Arrays.sort(A);
        Arrays.sort(B);
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list1Odd=new ArrayList<Integer>();
        List<Integer> list1Even=new ArrayList<Integer>();
        List<Integer> list2Odd=new ArrayList<Integer>();
        List<Integer> list2Even=new ArrayList<Integer>();
        for(int num:A){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:B){
            if(map.containsKey(num)){
                map.put(num,map.get(num)-1);
                if(map.get(num)==0){
                    map.remove(num);
                }
            }
            else{
                if(num%2==0){
                    list2Even.add(num);
                }
                else{
                    list2Odd.add(num);
                }
            }
        }
        for(int num:A){
            if(map.containsKey(num)){
                map.put(num,map.get(num)-1);
                if(map.get(num)==0){
                    map.remove(num);
                }
                if(num%2==0){
                    list1Even.add(num);
                }
                else{
                    list1Odd.add(num);
                }
            }
        }
        if(list1Even.size()!=list2Even.size()){
            return -1;
        }
        long ans=0;
        long ans1=0;
        for(int i=0;i<list1Even.size();i++){
            long temp=list1Even.get(i)-list2Even.get(i);
            if(temp%2!=0){
                return -1;
            }
            long temp1=temp/2;
            ans1+=temp1;
            ans+=Math.abs(temp1);
        }
        for(int i=0;i<list1Odd.size();i++){
            long temp=list1Odd.get(i)-list2Odd.get(i);
            if(temp%2!=0){
                return -1;
            }
            long temp1=temp/2;
            ans1+=temp1;
            ans+=Math.abs(temp1);
        }
        if(ans1==0){
            return ans/2;
        }
        return -1;
    }
}
        
