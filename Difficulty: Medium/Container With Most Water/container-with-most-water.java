//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        /*int ans=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int local =(j-i)*(Math.min(arr[i],arr[j]));
                if(local> ans) ans=local;
            }
        }
        return ans;*/
        int left=0;
        int right=arr.length-1;
        int ans =0;
        while(left<right){
        int tempwater=Math.min(arr[left],arr[right])*(right-left);
        ans=Math.max(ans,tempwater);
        if(arr[left]<arr[right])left++;
        else right--;
        }
        return ans;
    }
}