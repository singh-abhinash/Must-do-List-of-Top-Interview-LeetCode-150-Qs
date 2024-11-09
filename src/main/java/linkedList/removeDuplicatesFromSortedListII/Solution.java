package linkedList.removeDuplicatesFromSortedListII;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        // Sentinel node to handle edge cases
        ListNode sentinel = new ListNode(0, head);
        
        // Initialize pointers
        ListNode prevNode = sentinel;
        ListNode currNode = head;
        
        while (currNode != null) {
            // Check if there is a duplicate sequence starting at `curr`
            if (currNode.next != null && currNode.val == currNode.next.val) {
                // Move `curr` forward until the end of the duplicate sequence
                while (currNode.next != null && currNode.val == currNode.next.val) {
                    currNode = currNode.next;
                }
                // Skip all duplicates by linking `prev.next` to `curr.next`
                prevNode.next = currNode.next;
            } else {
                // No duplicate for `curr`, move `prev` to `curr`
                prevNode = prevNode.next;
            }
            // Move `curr` forward
            currNode = currNode.next;
        }
        
        return sentinel.next;
    }
}
