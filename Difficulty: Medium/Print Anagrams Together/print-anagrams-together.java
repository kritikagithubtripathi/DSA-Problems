//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String, ArrayList<String>> ans = new HashMap<>();
        for(String i : arr){
            char ch[] = i.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(ans.containsKey(s)){
                ans.get(s).add(i);
            }
            else{
                ArrayList<String> p = new ArrayList<>();
                p.add(i);
                ans.put(s, p);
            }
        }
        return new ArrayList<>(ans.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends