package linkedList.reverseLinkedListII;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**See this solution for better understanding:
 * https://leetcode.com/problems/reverse-linked-list-ii/solutions/2311084/java-c-tried-to-explain-every-step/?envType=study-plan-v2&envId=top-interview-150
 */

public class OnePassApproach {
	public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if there's no need to reverse
        if (left == right) {
            return head;
        }
        
        // Create a dummy node to simplify the process
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Traverse to the node just before the `left` position
        ListNode prevNode = dummy;
        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
        }
        
        // Step 2: Start reversing the sublist from `left` to `right`
        ListNode currNode = prevNode.next;
        ListNode nextNode;
        for (int i = 0; i < right - left; i++) {
            nextNode = currNode.next;
            currNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }
        
        // Return the modified list
        return dummy.next;
    }
}
