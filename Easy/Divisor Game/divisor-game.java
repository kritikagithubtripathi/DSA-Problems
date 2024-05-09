//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            String ans = obj.divisorGame(n) ? "True" : "False";
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public static boolean divisorGame(int n) {
        // code here
        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(n, memo);
    }
    public static boolean canWin(int n, Map<Integer, Boolean> memo) {
        if (n == 1) {
            // If n is 1, Alice cannot make a move and loses
            return false;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Check all possible moves for Alice
        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                // If Alice can make a move resulting in a position where Bob loses,
                // Alice wins
                if (!canWin(n - x, memo)) {
                    memo.put(n, true);
                    return true;
                }
            }
        }

        // If no winning move found, Alice loses
        memo.put(n, false);
        return false;
    }
}