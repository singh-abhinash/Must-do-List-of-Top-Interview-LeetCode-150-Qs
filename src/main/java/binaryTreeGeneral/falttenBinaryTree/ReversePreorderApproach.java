package binaryTreeGeneral.falttenBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ReversePreorderApproach {
	TreeNode prevNode = null;
	
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prevNode;
        root.left = null;

        prevNode = root;
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 *     1
      / \
     2   5
    / \    \
   3   4    6
   
   Reverse Preorder (right -> left -> current):

Start at 1, go to 5, then 6.
Link 6 to null (it's the last node).
Go back to 5, set 5.right = 6 and 5.left = null.
Go back to 1, now process the left subtree (2).
Process 4, link 4.right = 5 (prev = 5), and 4.left = null.
Process 3, link 3.right = 4 (prev = 4), and 3.left = null.
Process 2, link 2.right = 3 (prev = 3), and 2.left = null.
Finally, process 1, link 1.right = 2 (prev = 2), and 1.left = null.

1 -> 2 -> 3 -> 4 -> 5 -> 6

Improved Extra Space Approach
Idea:

Use recursion to traverse the binary tree in reverse preorder.
As we visit each node, directly build the new flattened tree by linking the right pointer of the previous node to the current node.
Maintain a global (or instance) reference to the "previous node" so we can link it to the current node.

Time and Space Complexity
	• Time Complexity: O(N), since we traverse each node exactly once.
	• Space Complexity:
		○ Extra space used in the stack due to recursion.
		○ The recursion depth is proportional to the height of the tree.
		○ In the worst case (skewed tree), it will be O(N), and in the best case (balanced tree), it will be O(log⁡N).


 */
