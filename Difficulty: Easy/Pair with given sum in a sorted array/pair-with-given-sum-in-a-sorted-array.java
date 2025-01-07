//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int n = arr.length;
        int left = 0, right = n - 1;
        int count = 0;

        while (left < right) {
            int currSum = arr[left] + arr[right];

            if (currSum == target) {
                int leftVal = arr[left], rightVal = arr[right];

                if (leftVal == rightVal) {
                    int numElements = right - left + 1;
                    count += (numElements * (numElements - 1)) / 2;
                    break;
                }

                int leftCount = 0, rightCount = 0;
                while (left <= right && arr[left] == leftVal) {
                    left++;
                    leftCount++;
                }
                while (left <= right && arr[right] == rightVal) {
                    right--;
                    rightCount++;
                }

                count += leftCount * rightCount;
            } else if (currSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends