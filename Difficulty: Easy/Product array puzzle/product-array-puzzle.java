//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int nums[]) {
        long total = 1l;
        int ct = 0;
        for(int num : nums) {
            if(num == 0) ct++;
            else total *= num;
        }
        
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            int num = nums[i];
            if(num == 0) {
                if(ct > 1) res[i] = 0;
                else res[i] = (int)total;
            } else {
                if(ct>0) res[i] = 0;
                else res[i] = (int)(total/num);
            }
        }
        
        return res;
    }
}