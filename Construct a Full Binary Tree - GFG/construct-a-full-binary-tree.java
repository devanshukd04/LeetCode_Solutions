//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
        for(int i=0;i<pre.length;i++){
            map1.put(pre[i],i);
        }
        HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
        for(int i=0;i<preM.length;i++){
            map2.put(preM[i],i);
        }
        return helper(map1,map2,pre,preM,0,pre.length-1,0,preM.length-1);
    }
    public Node helper(HashMap<Integer,Integer> map1,HashMap<Integer,Integer> map2,int[] pre,int[] preM,int start1,int end1,int start2,int end2){
        if(start1==end1 || start2==end2){
            return new Node(pre[start1]);
        }
        Node root=null;
        if(pre[start1]==preM[start2]){
            root=new Node(pre[start1]);
            start1++;
            start2++;
        }
        int index1=map1.get(preM[start2]);
        int index2=map2.get(pre[start1]);
        root.left=helper(map1,map2,pre,preM,start1,index1-1,index2,end2);
        root.right=helper(map1,map2,pre,preM,index1,end1,start2,index2-1);
        return root;
    }
    
}