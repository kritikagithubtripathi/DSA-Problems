//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean solveSudoku(int[][] mat) {
        for (int row = 0; row < 9; row++) { // Iterate through rows
            for (int col = 0; col < 9; col++) { // Iterate through columns
                if (mat[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= 9; num++) { // Try numbers 1-9
                        if (isValid(mat, row, col, num)) { // Check if the number is valid
                            mat[row][col] = num; // Place the number

                            if (solveSudoku(mat)) { // Recursively solve
                                return true; 
                            } else {
                                mat[row][col] = 0; // Backtrack (reset the cell)
                            }
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true; // Sudoku is solved
    }

    // Helper function to check if a number is valid in a cell
    boolean isValid(int[][] mat, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (mat[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}