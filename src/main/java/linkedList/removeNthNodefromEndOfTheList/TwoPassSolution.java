package linkedList.removeNthNodefromEndOfTheList;



public class TwoPassSolution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate the length of the list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Find the position to delete from the start
        int positionToDelete = length - n;
        
        // If the node to delete is the head node
        if (positionToDelete == 0) {
            return head.next;
        }
        
        // Traverse to the node just before the one we need to delete
        current = head;
        for (int i = 1; i < positionToDelete; i++) {
            current = current.next;
        }
        
        // Remove the nth node from the end
        current.next = current.next.next;
        
        return head;
    }
}
