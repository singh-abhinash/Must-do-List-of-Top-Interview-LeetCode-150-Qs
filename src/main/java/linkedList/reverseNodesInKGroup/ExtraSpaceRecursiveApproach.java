package linkedList.reverseNodesInKGroup;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
	 
public class ExtraSpaceRecursiveApproach {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) 
            return head;
        
        // Step 1: Count k nodes from the current head
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        
        // If there are fewer than k nodes, return the head (no need to reverse)
        if (count < k) 
            return head;
        
        // Step 2: Reverse the first k nodes
        ListNode prevNode = null, nextNode = null, currNode = head;
        count = 0;
        while (count < k && currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }
        
        // Step 3: Recursive call to reverse the remaining nodes
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }
        
        // Step 4: Return the new head of the reversed list
        return prevNode;
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity
 * -> Each recursive call processes k nodes, and there are N/k groups of nodes.
 * -> Time = O(N), where N is the total number of nodes.
 * 
 * Space Complexity
 * -> Each recursive call adds to the call stack.
 * -> Space = O(N / k) recursive calls.
 * -> In the worst case, if k=1, the space complexity would be O(N).
 */