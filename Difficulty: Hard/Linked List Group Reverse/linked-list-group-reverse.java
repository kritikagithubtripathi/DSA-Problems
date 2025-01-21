//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
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
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null||head.next==null||k==1)
        {
            return head;
        }
        Node temp=head;
        int c=0;
        int n=0;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        return reverse(head,k,n);
    }
    private static Node reverse(Node head,int k,int n)
    {
        if(n==0)
        {
            return head;
        }
        if(n<k)
        {
            Node prev=null;
            Node cur=head;
            Node Next=null;
            int c=0;
            while(c<n&&cur!=null)
            {
                Next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=Next;
                c++;    
            } 
            return prev;
        }
        Node prev=null;
        Node cur=head;
        Node Next=null;
        int c=0;
        while(c<k&&cur!=null)
        {
            Next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Next;
            c++;    
        }
        if(cur!=null)
        {
            head.next=reverse(cur,k,n-k);
        }
        return prev;
    }
}