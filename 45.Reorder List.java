class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) 
        return ;

    // step 1 find middle
        ListNode slow = head ;
        ListNode fast = head ;

        while(fast != null && fast.next != null ) {
            slow = slow.next ;
            fast = fast . next.next ;
        }


        // step 2 reverse the second half 

        ListNode prev = null ;
        ListNode curr = slow.next;
        slow .next = null ;

        while(curr !=null ) {
            ListNode next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        // step 3 merge 
        ListNode first = head ;
        ListNode second = prev ;

        while(second != null ) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next ;

            first.next = second ;
            second.next = temp1 ;
            first = temp1 ;
            second = temp2 ;
        }
    }
}
