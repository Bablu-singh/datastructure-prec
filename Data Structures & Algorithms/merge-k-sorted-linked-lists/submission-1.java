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
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];

    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode l = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                l.next = list1;
                list1 = list1.next;
            } else {
                l.next = list2;
                list2 = list2.next;
            }
            l = l.next;
        }

        if (list1 != null) {
            l.next = list1;
        } else if (list2 != null) {
            l.next = list2;
        }
        return dummy.next;
    }
}
