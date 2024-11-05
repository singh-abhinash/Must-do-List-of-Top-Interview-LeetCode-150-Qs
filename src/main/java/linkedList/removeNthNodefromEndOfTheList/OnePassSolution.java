package linkedList.removeNthNodefromEndOfTheList;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//In One Pass - O(Length of linkedList), O(1) space
class OnePassSolution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Initialize two pointers at the head of the list
        ListNode first = head;
        ListNode second = head;
        
        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        
        // If first is null after moving n steps, it means we need to remove the head
        if (first == null) {
            return head.next;
        }
        
        // Move both pointers until first reaches the end of the list
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from the end
        second.next = second.next.next;
        
        return head;
	}
}