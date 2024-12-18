package binaryTreeGeneral.falttenBinaryTree;

public class MorrisTraversalApproach {
	public void flatten(TreeNode root) {
        TreeNode currNode = root;

        while (currNode != null) {
            // If there is a left child, we need to move it to the right
            if (currNode.left != null) {
                // Find the rightmost node in the left subtree (predecessor)
                TreeNode rightMostNode = currNode.left;
                while (rightMostNode.right != null) {
                    rightMostNode = rightMostNode.right;
                }

                // Connect the current node's right subtree to the rightmost node
                rightMostNode.right = currNode.right;

                // Move the left subtree to the right and set the left child to null
                currNode.right = currNode.left;
                currNode.left = null;
            }

            // Move to the next node (which is always curr.right)
            currNode = currNode.right;
        }
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

/**
 * Constant Space Approach (O(1) Space) to Flatten Binary Tree to Linked List
To flatten a binary tree to a "linked list" in O(1) extra space, we avoid using recursion (which takes space on the call 
stack) and avoid any extra data structures like lists or arrays.
The key to this approach is to "rearrange the tree in place" by reusing the existing pointers in the TreeNode structure.

Intuition:
We use a concept similar to Morris Traversal (used for in-order traversal) to flatten the binary tree in pre-order without 
recursion or extra space.
How?
	• If a node has a left child, we want to move the entire left subtree to the right side of the node.
	• To do this, we need to find the "rightmost node" of the left subtree, so we can connect it to the original right child.
	• We repeat this process for each node as we move down the tree.

Steps to Flatten the Tree
	1. Start at the root.
	2. For every node curr:
		○ If the node has a left child:
			§ Find the rightmost node in the left subtree (this is called the "predecessor" in Morris Traversal).
			§ Link the right subtree of the current node to the rightmost node's right.
			§ Move the entire left subtree to become the right subtree.
			§ Set curr.left = null to "flatten" it as a linked list.
		○ Move to the next node (which is curr.right because we always link the new subtree on the right).
	3. Repeat until you reach the end of the tree (when curr is null).

Diagram Walkthrough
Consider the following tree:

       1
      / \
     2   5
    / \    \
   3   4    6
   
	1. Start with 1.
		○ It has a left child (2), so we find the rightmost node of the left subtree.
		○ The rightmost node of subtree rooted at 2 is 4.
		○ Link 4.right to 1.right (which is 5).
		○ Move the entire left subtree of 1 to the right.
		○ The tree now looks like this:

    1
     \
      2
     / \
    3   4
         \
          5
           \
            6
            
	2. Move to 2.
		○ It has a left child (3), so we find the rightmost node of the left subtree.
		○ The rightmost node of subtree rooted at 3 is 3 itself (since it has no right child).
		○ Link 3.right to 2.right (which is 4).
		○ Move the entire left subtree of 2 to the right.
		○ The tree now looks like this:

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
              
	3. Move to 3, then to 4, and so on. These nodes don't have left children, so we just keep moving to the right.
Final flattened tree (which is like a linked list):

1 -> 2 -> 3 -> 4 -> 5 -> 6


Explanation of the Key Steps
	1. Find the Rightmost Node:
		○ We find the "predecessor" (rightmost node) of the current node's left subtree.
		○ This is done using the while (rightmost.right != null) loop.
	2. Link Right Subtree to the Rightmost Node:
		○ The right subtree of the current node is attached to the right pointer of the rightmost node of the left subtree.
	3. Move the Left Subtree to the Right:
		○ We move the left subtree to the right by reassigning curr.right = curr.left.
		○ Nullify the left pointer using curr.left = null.
	4. Move to the Next Node:
		○ Since the entire left subtree has been shifted to the right, the next node to process is curr.right.

Time and Space Complexity
	• Time Complexity:
Each node is visited at most twice (once when we process it and another time when we find the rightmost node).
Hence, the time complexity is O(N) where NNN is the number of nodes.
	• Space Complexity:
		○ No recursion is used, and no extra data structures like arrays or lists are used.
		○ We only use a few extra pointers (curr and rightmost).
Hence, space complexity is O(1) extra space.


Example Walkthrough
Input:

       1
      / \
     2   5
    / \    \
   3   4    6
   
Step-by-step changes:

Initial tree:              After processing node 1:
      1                           1
     / \                            \
    2   5                            2
   / \   \                              \
  3   4   6                             3
                                       / \
                                      4   5
                                           \
                                            6
                                            
After processing node 2:        After processing node 3:
      1                               1
       \                                \
        2                                2
         \                                \
          3                                3
           \                                \
            4                                4
             \                                \
              5                                5
               \                                \
                6                                6
                
Final flattened tree:

1 -> 2 -> 3 -> 4 -> 5 -> 6

Key Takeaways
	1. If O(1) space is required, use the Morris-like traversal approach.
	2. The key idea is to re-link the left subtree to the right by finding the rightmost node.
	3. No recursion, no extra array, no call stack space — purely iterative.
	4. Space complexity is O(1) and time complexity is O(N).

 */
