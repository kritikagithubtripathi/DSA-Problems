//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int countWays(int n, String s){
        // code here
        int dp[][][]=new int[n+1][n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return f(0,n-1,1,dp,s);
    }
    static int f(int st,int end,int isTrue,int[][][] dp,String s){
        int mod=1003;
        if(st>end){
            return 0;
        }
        if(st==end){
            if(isTrue==1)
               return s.charAt(st)=='T'?1:0;
            else
               return s.charAt(st)=='F'?1:0;
        }
        if(dp[st][end][isTrue]!=-1){
            return dp[st][end][isTrue];
        }
        int ways=0;
        for(int idx=st+1;idx<end;idx+=2){
            int lt=f(st,idx-1,1,dp,s);
            int rt=f(idx+1,end,1,dp,s);
            int lf=f(st,idx-1,0,dp,s);
            int rf=f(idx+1,end,0,dp,s);
            
            if(s.charAt(idx)=='&'){
                if(isTrue==1){
                    ways+=(lt*rt);
                }else{
                    ways+=(lt*rf+lf*rt+lf*rf);
                }
            }else if(s.charAt(idx)=='|'){
                if(isTrue==1){
                    ways+=(lt*rt+lf*rt+rf*lt);
                }else{
                    ways+=(lf*rf);
                }
            }else{
                if(isTrue==1){
                    ways+=(lf*rt+lt*rf);
                }else{
                    ways+=(lt*rt+lf*rf);
                }
            }
        }
        return dp[st][end][isTrue]=ways%mod;
    }
}




