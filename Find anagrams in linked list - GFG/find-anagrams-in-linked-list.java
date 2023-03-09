//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        Node temp1=null;
        int start=0;
        int end=0;
        ArrayList<Node> ans=new ArrayList<Node>();
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        Node temp=head;
        Node temp2=null;
        while(temp!=null){
            while((end-start)<s.length() && temp!=null){
                if(start==end){
                    temp1=temp;
                }
                map1.put(temp.data,map1.getOrDefault(temp.data,0)+1);
                temp2=temp;
                temp=temp.next;
                end++;
            }
            if(map.equals(map1)){
                ans.add(temp1);
                temp2.next=null;
                start=end;
                map1.clear();
            }
            else{
                map1.put(temp1.data,map1.getOrDefault(temp1.data,0)-1);
                if(map1.get(temp1.data)==0){
                    map1.remove(temp1.data);
                }
                if(temp1!=null){
                    temp1=temp1.next;
                }
                start+=1;
            }
        }
        return ans;
    }
}