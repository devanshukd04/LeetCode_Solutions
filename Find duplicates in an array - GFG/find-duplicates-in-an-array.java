//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> visitedSet=new HashSet<Integer>();
        for(int num:arr){
            if(set.contains(num) && !visitedSet.contains(num)){
                list.add(num);
                visitedSet.add(num);
            }
            set.add(num);
        }
        if(list.size()==0){
            list.add(-1);
            return list;
        }
        Collections.sort(list);
        return list;
    }
}
