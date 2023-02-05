//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
 class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {
   //Node temp = head;
   //while (temp.next != null)
    //temp = temp.next;

   //temp.next = node;
   tail.next=node;
   tail = node;
  }
}

  /* Function to print linked list */
    void printList(PrintWriter out)
    {
        Node temp = head;
        while (temp != null)
        {
           out.print(temp.data+" ");
           temp = temp.next;
        }  
        out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])throws IOException
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out=new PrintWriter(System.out);
		 int t=Integer.parseInt(in.readLine().trim());
		 
		 while(t>0)
         {
            String s[]=in.readLine().trim().split(" ");
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			int n3 = Integer.parseInt(s[2]);
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		    LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
			    s=in.readLine().trim().split(" ");
				int a1=Integer.parseInt(s[0]);
				Node head1= new Node(a1);
				Node tail1= head1;
				
				for (int i = 1; i < n1; i++) 
				{
					int a = Integer.parseInt(s[i]); 
					tail1.next = (new Node(a));
					tail1= tail1.next;
				}
			
			    s=in.readLine().trim().split(" ");
				int b1=Integer.parseInt(s[0]);
				Node head2 = new Node(b1);
				Node tail2 = head2;
				for (int i = 1; i < n2; i++) 
				{
					int b = Integer.parseInt(s[i]);  
					tail2.next = (new Node(b));
					tail2= tail2.next;
				}
				
				s=in.readLine().trim().split(" ");
				int c1=Integer.parseInt(s[0]);
				Node head3= new Node(c1);
				tail1.next = head3;
				tail2.next = head3;
				Node tail3=head3;
				for (int i = 1; i < n3; i++) 
				{
					int c = Integer.parseInt(s[i]); 
					tail3.next = (new Node(c));
					tail3= tail3.next;
				}
				
				Intersect obj = new Intersect();
				out.println(obj.intersectPoint(head1, head2));
			t--;			
         }
         out.close();
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         int length1=0;
         Node temp=head1;
         while(temp!=null){
             temp=temp.next;
             length1++;
         }
         int length2=0;
         temp=head2;
         Node temp1=null;
         while(temp!=null){
             temp=temp.next;
             length2++;
         }
         int dist=0;
         if(length2>=length1){
             dist=length2-length1;
             temp=head2;
             temp1=head1;
         }
         else{
             dist=length1-length2;
                temp=head1;
                temp1=head2;
        }
        while(dist>0){
            temp=temp.next;
            dist--;
        }
        while(temp!=temp1){
            temp=temp.next;
            temp1=temp1.next;
        }
        return temp.data;
	}
}


