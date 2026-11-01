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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode tail = node;

        ListNode curr = list1;
        ListNode curr1= list2;

        while(curr!=null && curr1!=null){
            if(curr.val <= curr1.val){
                tail.next = curr;
                curr = curr.next;
            }else{
                tail.next = curr1;
                curr1=curr1.next;
            }
            tail = tail.next;
        }
        if(curr!=null){
            tail.next = curr;
        }
        else if(curr1!=null){
            tail.next = curr1;
        }
        return node.next;
    }
}