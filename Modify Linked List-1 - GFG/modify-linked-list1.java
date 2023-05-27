//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        Node slow=head;
        Node fast=head;
        Node temp1=head;
        while(fast!=null && fast.next!=null){
            temp1=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp1.next=null;
        Node secondHalf=reverse(slow);
        temp1=secondHalf;
        Node temp=head;
        Node temp2=head;
        while(temp!=null){
            int tempVal=temp.data;
            temp.data=secondHalf.data-tempVal;
            secondHalf.data=tempVal;
            temp2=temp;
            secondHalf=secondHalf.next;
            temp=temp.next;
        }
        temp2.next=reverse(temp1);
        return head;
        
    }
    public static Node reverse(Node head){
        Node temp=head;
        Node temp1=head.next;
        head.next=null;
        while(temp!=null && temp1!=null){
            Node temp2=temp1.next;
            temp1.next=temp;
            temp=temp1;
            temp1=temp2;
        }
        return temp;
    }
}