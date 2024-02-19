//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java





class Solution{
    static int minValue(String s, int k){
        // code here 
        int fre[] = new int[26];  
        int n = s.length();
        for(int i = 0; i < n; i++) {
            fre[s.charAt(i)-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int i = 0; i < 26; i++) {
            if(fre[i] != 0) pq.add(fre[i]);
        }
        while(k > 0 && !pq.isEmpty()) {
            int ele = pq.remove(); 
            ele -= 1; 
            if(ele > 0) pq.add(ele);
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()) { 
            ans += Math.pow(pq.remove(), 2);
        }
        return ans;
    }
}