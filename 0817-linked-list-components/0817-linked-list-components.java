import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        if (head == null) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, null);
        }

        int count = 0;
        ListNode current = head;
        while (current != null) {
            if (map.containsKey(current.val) && (current.next == null || !map.containsKey(current.next.val))) {
                count++;
            }
            current = current.next;
        }
        
        return count;
    }
}
