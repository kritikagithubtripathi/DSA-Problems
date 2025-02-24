//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends





class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> ans=new ArrayList<>();
    	HashMap<Integer,Integer> map=new HashMap<>();
    	int n=arr.length;
    	Stack<Integer> st=new Stack<>();
    	st.add(arr[0]);
    	int span[]=new int[n];
    	span[0]=-1;
    	map.put(arr[0],0);
    	int spanInd[]=new int[n];
    	
    	for(int i=1;i<n;i++) {
    	    map.put(arr[i], i);    
    		if(arr[i]<st.peek()){
    			span[i]=st.peek();
    			st.push(arr[i]);
    			spanInd[i]=map.get(span[i]);
    		}else {
    			while(!st.isEmpty() && st.peek()<=arr[i]) {
    				st.pop();
    			}
    			if(st.size()==0) {
    				span[i]=-1;
    				st.add(arr[i]);
    			}else {
    				span[i]=st.peek();
    				spanInd[i]=map.get(span[i]);
    				st.add(arr[i]);    				
    			}
    		}
    	}
    	
    	ans.add(1);
    	for(int i=1;i<n;i++) {
    		if(span[i]==-1) {
    			ans.add(i+1);
    			continue;
    		}
    		int temp=i-spanInd[i];
    		ans.add(temp);
    	}
    	
    	
        return ans; 
    }
}