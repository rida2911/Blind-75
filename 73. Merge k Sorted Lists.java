class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>minHeap = new PriorityQueue<>((a, b ) -> a.val - b.val) ;

        for(ListNode list : lists) {
            if(list != null ) {
                minHeap.offer(list) ;
            }
        }
        ListNode dummy = new ListNode(0) ;
        ListNode Current = dummy ;

        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            Current.next = node ;
            Current = Current.next;

            if(node.next != null ){
            minHeap.offer(node.next);
        }
        
    }
      return dummy.next;
    }
}
