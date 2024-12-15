package linkedList.rotateList;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;

        // Calculate the length of the linked list
        ListNode current = head;
        int length = 1; // Length of the list (at least 1 node)
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Make the linked list circular
        current.next = head; // Connect the last node to the head, forming a circle

        // Calculate the effective rotation
        k = k % length; 
        if (k == 0) { 
            current.next = null; // Break the circular connection
            return head; // No rotation needed
        }

        // Find the new tail position (length - k steps from the start)
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Update the head and break the circular connection
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
