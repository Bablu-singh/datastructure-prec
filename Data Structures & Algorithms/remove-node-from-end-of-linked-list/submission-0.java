class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode leftP = dummy;
        ListNode rightP = head;

        
        while( rightP!=null && n>0){
            rightP = rightP.next;
            n--;
        }
        while (rightP!=null){
            leftP = leftP.next;
            rightP = rightP.next;
        }

        leftP.next = leftP.next.next;
        return dummy.next;
       
    }
}
