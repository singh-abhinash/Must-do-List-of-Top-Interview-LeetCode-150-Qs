package binaryTreeGeneral.binarySearchTreeIterator;

import java.util.Stack;

public class StackBasedApproach {
	private Stack<TreeNode> stack; // Stack to store the path of the in-order traversal

    public StackBasedApproach(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root); // Push all the left children of the root
    }

    // Returns the next in-order value
    public int next() {
        TreeNode node = stack.pop(); // Pop the top of the stack
        if (node.right != null) {
            pushLeft(node.right); // If right child exists, push its left children
        }
        return node.val; // Return the value of the node
    }

    // Returns true if there are more nodes to process
    public boolean hasNext() {
        return !stack.isEmpty(); // If the stack is not empty, there are nodes left to visit
    }

    // Helper method to push all the left children of the node
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node); // Push the current node
            node = node.left; // Move to the left child
        }
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * next involves two major operations. One is where we pop an element from the stack which becomes the next smallest element 
 * to return. This is a O(1) operation. However, we then make a call to our helper function _inorder_left which iterates over
 *  a bunch of nodes. This is clearly a linear time operation i.e. O(N) in the worst case. This is true.

However, the important thing to note here is that we only make such a call for nodes which have a right child. Otherwise, we 
simply return. Also, even if we end up calling the helper function, it won't always process N nodes. 
They will be much lesser. Only if we have a skewed tree would there be N nodes for the root. But that is the only node for 
which we would call the helper function.

Thus, the amortized (average) time complexity for this function would still be O(1) which is what the question asks for. We 
don't need to have a solution which gives constant time operations for every call. We need that complexity on average and 
that is what we get.
 */
