package binaryTreeGeneral.populatingNextRightPointerInEachNodeII;

public class RecursiveApproach {
	public Node connect(Node root) {
        if (root == null) 
            return null;

        // Connect left child to right child (internal to same subtree)
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : getNextChild(root.next);
        }

        // Connect right child to the next node's child (cross-level connection)
        if (root.right != null) {
            root.right.next = getNextChild(root.next);
        }

        // **Recursive call for right before left** to ensure that next pointers are established
        connect(root.right);
        connect(root.left);

        return root;
    }

    // Helper method to find the next child to connect
    private Node getNextChild(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}
