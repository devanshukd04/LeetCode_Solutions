//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class TrieNode{
    public TrieNode[] links;
    public TrieNode(){
        links=new TrieNode[26];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    } 
    public void put(char ch, TrieNode node){
        links[ch-'a']=node;
    }
}
class Solution
{
    private TrieNode root;
    public int prefixSuffixString(String s1[],String s2[])
    {
        int ans=0;
        root=new TrieNode();
        for(String s:s1){
            insert(s);
        }
        for(String s:s2){
            if(searchPrefix(s)){
                ans++;
            }
        }
        return ans;
    }
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                node.put(curr,new TrieNode());
            }
            node=node.links[curr-'a'];
        }
        node=root;
        for(int i=word.length()-1;i>=0;i--){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                node.put(curr,new TrieNode());
            }
            node=node.links[curr-'a'];
        }
    }
    public boolean searchPrefix(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                return searchSuffix(word);
            }
            node=node.links[curr-'a'];
        }
        return true;
    }
    public boolean searchSuffix(String word){
        TrieNode node=root;
        for(int i=word.length()-1;i>=0;i--){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                return false;
            }
            node=node.links[curr-'a'];
        }
        return true;
    }
    
}