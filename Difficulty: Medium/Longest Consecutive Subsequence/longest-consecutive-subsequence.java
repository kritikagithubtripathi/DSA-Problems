//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0; 
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int i : arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
            set.add(i);
        }
        int m = 1;
        int cnt = 1;
        for(int i = min; i<max; i++){
            if(set.contains(i+1)){
                cnt++;
            }else{
                m = Math.max(cnt, m);
                cnt = 0;
            }
        }
        return Math.max(cnt, m);
    }
}