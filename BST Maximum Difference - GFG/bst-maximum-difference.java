//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   static HashSet<Integer> set;
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int sum=0;
        set=new HashSet<Integer>();
        Node curr=root;
        while(curr!=null){
            if(curr.data==target){
                break;
            }
            else if(curr.data>target){
                sum+=curr.data;
                curr=curr.left;
            }
            else{
                sum+=curr.data;
                curr=curr.right;
            }
        }
        if(curr==null){
            return -1;
        }
        if(curr.left==null && curr.right==null){
            return sum;
        }
        helper(curr.left,0);
        helper(curr.right,0);
        int ans=Integer.MIN_VALUE;
        for(int num:set){
            ans=Math.max(ans,sum-num);
        }
        return ans;
    }
    public static void helper(Node root,int currSum){
        if(root==null){
            return;
        }
        currSum+=root.data;
        if(root.left==null && root.right==null){
            set.add(currSum);
            return;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);
    }
}