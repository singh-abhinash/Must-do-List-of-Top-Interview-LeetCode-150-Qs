package linkedList.reverseNodesInKGroup;

public class ConstantSpaceInPlaceApproach {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) 
            return head;

        // Step 1: Dummy node for convenience
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Step 2: Check if there are k nodes left to reverse
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }
            if (kthNode == null) break; // Less than k nodes left
            
            // Step 3: Reverse the k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;

            // Reverse the group
            ListNode prev = null, curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Step 4: Connect the reversed group
            prevGroupEnd.next = prev;      // New start of this group
            groupStart.next = nextGroupStart; // Connect to the next group

            // Step 5: Move to the next group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Explanation:
	1. Dummy Node:
A dummy node is used to simplify edge cases like when the head itself is part of a reversed group.
	2. Iterative Reversal:
The inner while loop reverses the k nodes iteratively, ensuring constant space usage.
	3. Connection Handling:
		○ The prevGroupEnd points to the end of the previously reversed group and is updated to the start of the current group after reversal.
		○ The nextGroupStart ensures the remaining part of the list is linked after the reversal.
	4. Termination Condition:
The outer while loop checks if there are at least k nodes remaining; if not, it terminates.
Complexity:
	• Time Complexity: O(N), as we traverse each node once.
	• Space Complexity: O(1), as no additional space is used beyond a few pointers.

 */
