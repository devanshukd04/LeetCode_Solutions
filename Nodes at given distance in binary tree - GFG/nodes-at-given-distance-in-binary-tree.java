//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static Node SearchTarget(Node root,int val){
        if(root==null)return null;
        if(root.data==val)return root;
        Node left=SearchTarget(root.left,val);
        Node right=SearchTarget(root.right,val);
        if(left==null)return right;
        return left;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        HashMap<Node,Node>mp=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            Node temp=q.remove();
            if(temp.left!=null){
                mp.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                mp.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<Node,Integer>isVisit=new HashMap<>();
        Queue<Node>q1=new LinkedList<>();
        Node node=SearchTarget(root,target);
        q1.add(node);
        isVisit.put(node,0);
        while(q1.size()!=0){
            Node temp=q1.poll();
            
            if(temp.left!=null && !isVisit.containsKey(temp.left)){
                Node left=temp.left;
                q1.add(left);
                isVisit.put(left,isVisit.get(temp)+1);
                if(isVisit.get(left)==k){
                    ans.add(left.data);
                }
            }
            
            if(temp.right!=null && !isVisit.containsKey(temp.right)){
                Node right=temp.right;
                q1.add(right);
                isVisit.put(right,isVisit.get(temp)+1);
                if(isVisit.get(right)==k){
                    ans.add(right.data);
                }
            }
            
            if(mp.containsKey(temp) && !isVisit.containsKey(mp.get(temp))){
                Node parent=mp.get(temp);
                q1.add(parent);
                isVisit.put(parent,isVisit.get(temp)+1);
                if(isVisit.get(parent)==k){
                    ans.add(parent.data);
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
};