//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Queue; 
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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        Node node;
        int index;
        int level;
        Pair(Node node,int index,int level){
            this.node=node;
            this.index=index;
            this.level=level;
        }
    }
    long verticallyDownBST(Node root,int target)
    {
        boolean find=false;
        int index=0;
        int level=0;
        long ans=-1;
        Queue<Pair> queue=new LinkedList<Pair>();
        queue.add(new Pair(root,0,0));
        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                Pair node=queue.poll();
                if(!find){
                    if(node.node.data==target){
                        queue.clear();
                        find=true;
                        index=node.index;
                        level=node.level;
                        ans=0;
                    }
                }
                else{
                    if(node.index==index && level<node.level){
                        ans+=node.node.data;
                    }
                }
                if(node.node.left!=null){
                    queue.add(new Pair(node.node.left,node.index-1,node.level+1));
                }
                if(node.node.right!=null){
                    queue.add(new Pair(node.node.right,node.index+1,node.level+1));
                }
            }
        }
        return ans;
    }
}