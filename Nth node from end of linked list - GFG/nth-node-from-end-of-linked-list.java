//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) 
    {
        data = d; 
        next = null;
    }
}
	

	
public class LinkedList_Element_From_Last
{
    Node head;  
	Node tail;
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	  
     /* Drier program to test above functions */
    public static void main(String args[])throws IOException
    {
         BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(in.readLine().trim());
		 
		 while(t>0)
         {
             String s[]=in.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
			//int n=Integer.parseInt(br.readLine());
			s=in.readLine().trim().split(" ");
			int a1=Integer.parseInt(s[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = Integer.parseInt(s[i]); 
				llist.addToTheLast(new Node(a));
			}
          
		//System.out.println(llist.head.data);
        Solution g = new Solution(); 
		//System.out.println(k);
		System.out.println(g.getNthFromLast(llist.head,k));
		
			t--;
		}
	}
}


	
	
// } Driver Code Ends


/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	Node temp=reverse(head);
    	while(temp!=null && (n-1)>0){
    	    temp=temp.next;
    	    n--;
    	}
    	return temp==null?-1:temp.data;
    }
    public Node reverse(Node head){
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
