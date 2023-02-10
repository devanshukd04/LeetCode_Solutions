//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        HashSet<Character> set=new HashSet<Character>(Arrays.asList('b','a','l','o','n'));
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }   
        }
        int ans=Integer.MAX_VALUE;
        for(char key:map.keySet()){
            if(key=='l' || key=='o'){
                ans=ans<map.get(key)/2?ans:map.get(key)/2;
            }
            else{
                ans=ans<map.get(key)?ans:map.get(key);
            }
            set.remove(key);
        }
        if(set.size()>0){
            return -1;
        }
        return ans;
    }
}