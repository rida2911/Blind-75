class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode Prev = null;
        ListNode Curr = head;

        while( Curr != null) {
            ListNode next = Curr.next ;
            Curr.next = Prev ;
            Prev = Curr ;
            Curr = next ;

        }
        
        return Prev ;
        
    }
}

//TC = 0(N) 
// SC = 0(1)
