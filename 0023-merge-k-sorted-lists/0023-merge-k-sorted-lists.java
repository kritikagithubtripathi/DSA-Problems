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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i = i + interval * 2)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            interval *= 2;

        }
        return lists[0];

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode(0);
        ListNode current = head;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;

            }
            current = current.next;
        }

        if(list1 != null)
            current.next = list1;
        else if(list2 != null)
            current.next = list2;

        return head.next;
    }
}
