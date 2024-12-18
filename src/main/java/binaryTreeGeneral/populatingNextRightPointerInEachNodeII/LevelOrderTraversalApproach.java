package binaryTreeGeneral.populatingNextRightPointerInEachNodeII;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

//Using level order traversal O(n) time and O(n) space
public class LevelOrderTraversalApproach {
	public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                // If there is a previous node, link it to the current node
                if (prevNode != null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;

                // Add the left and right children of the current node to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return root;
    }
}
