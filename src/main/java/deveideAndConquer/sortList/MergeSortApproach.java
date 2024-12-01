package deveideAndConquer.sortList;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortApproach {
	public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has one node, it is already sorted.
        if (head == null || head.next == null) {
            return head; 
        }

        // Split the list into two halves.
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two halves.

        // Recursively sort each half.
        left = sortList(left);
        right = sortList(right);

        // Merge the sorted halves.
        return merge(left, right);
    }

    // Helper method to find the middle of the linked list.
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted lists.
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes from either list.
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
