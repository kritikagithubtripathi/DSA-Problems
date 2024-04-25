//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {     // seen
    
    int max=Integer.MIN_VALUE;
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        
        if(m<3 || n<3){
            return -1;
        }
        
        
        for(int i=0;i<n-2;i++){
            for(int j=0; j<m-2;j++){
                
                visitHome(mat , i, j);
            }
        }
            return max;

      
    }
    
    
    private void visitHome(int[][] jd,int i , int j){
        
        
        int sum =0;
        
        sum+=jd[i][j]+jd[i][j+1]+jd[i][j+2];
        
        sum+=jd[i+1][j+1];
        
        sum+=jd[i+2][j]+jd[i+2][j+1]+jd[i+2][j+2];
        
        
        max=Math.max(max,sum);
    }
        
};