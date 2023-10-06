//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if(odd==null || odd.next==null){
            return;
        }
        Node head=odd;
        Node rev=head.next;
        Node revHead=rev;
        Node temp=rev.next;
        while(temp!=null && temp.next!=null){
            head.next=temp;
            head=temp;
            rev.next=temp.next;
            rev=rev.next;
            temp=rev.next;
        }
        
        if(temp!=null){
            head.next=temp;    
            head=temp;
        }
        head.next=null;
        rev.next=null;
        Node newRevHead=reverse(revHead);
        head.next=newRevHead;
    }
    public static Node reverse(Node head){
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}
