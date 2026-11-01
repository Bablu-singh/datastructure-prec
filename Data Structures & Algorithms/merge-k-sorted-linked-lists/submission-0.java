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
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        if(lists.length == 1){
            return lists[0];
        }
        for(int i=1;i<lists.length;i++){
            lists[i] = mergeTwoLists(lists[i],lists[i-1]);
        }
        return lists[lists.length-1];

    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null){ return list2;}
        else if (list2==null){return list1;}
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        ListNode curr = list1;
        ListNode curr2 = list2;

        while(curr!=null && curr2!=null){
            if(curr.val < curr2.val){
                l.next = curr;
                l= l.next;
                curr = curr.next;
            }else{
                l.next = curr2;
                l = l.next;
                curr2 = curr2.next;
            }
        }
        if(curr!=null){
            l.next = curr;
        }else if (curr2!=null){
            l.next = curr2;
        }
        return dummy.next;
    }
}
