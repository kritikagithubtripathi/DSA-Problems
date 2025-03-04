//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) dp[i][j]=-1;
        }
        return rec(arr,-1,0,dp);
    }
    static int rec(int[] arr, int prevInd, int ind,int[][] dp){
        if(ind>=arr.length) return 0;
        if(dp[prevInd+1][ind]!=-1) return dp[prevInd+1][ind];
        int ex = rec(arr,prevInd,ind+1,dp);
        int inc = 0;
        if(prevInd==-1||arr[prevInd]<arr[ind]){
            inc = 1+rec(arr,ind,ind+1,dp);
        }
        return dp[prevInd+1][ind] = Math.max(inc,ex);
    }
}