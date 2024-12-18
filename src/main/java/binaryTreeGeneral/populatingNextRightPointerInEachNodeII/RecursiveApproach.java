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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Line-by-Line Explanation

1️) Base Case

if (root == null) return null; 
	• Why?
If the root is null, the tree is empty, so we simply return null.
This also serves as the termination condition for recursion.
	• Example:
For an empty tree [], the function will exit here.

2️) Link Left Child to Right Child

if (root.left != null) {
    root.left.next = root.right != null ? root.right : getNextChild(root.next);
}
	• Why?
We need to connect the left child to the right child. If the right child exists, we directly link root.left.next = root.right.
If the right child does not exist, we need to find the next available child at the same level.
To find the next child, we use the helper function getNextChild(root.next), which searches the next nodes at the same level.
	• What is happening?
		○ If root.left exists, we check if root.right exists:
			§ If yes, connect root.left.next = root.right.
			§ If no, connect root.left.next = getNextChild(root.next), which finds the first child node on the same level starting from root.next.
	• Example:
For this tree:

        1
       / \
      2   3
     /     \
    4       5
		○ While processing node 2, it connects 4 → 5 by looking at getNextChild(3), which returns 5.

3️) Link Right Child to the Next Node's Child

if (root.right != null) {
    root.right.next = getNextChild(root.next);
}
	• Why?
After linking root.left, we now link root.right to the first child of root.next.
		○ If root.next has a child, we connect root.right.next = getNextChild(root.next).
		○ If no child is available, getNextChild returns null, and we link it to null.
	• Example:
For the following tree:

        1
       / \
      2   3
         / \
        6   7
        
		○ While processing node 2, the right child is null, so we move to node 3.
		○ At node 3, 6 will be connected to 7.
		○ If node 3 had a next node, we'd check for children in that subtree.

4️) Recursive Calls (Right Before Left)

connect(root.right);
connect(root.left);

	• Why "right before left"?
This is one of the most important details in this approach.
By handling the right child first, we ensure that all next pointers on the right side are set before we start connecting the left child.
When we connect left to right, we might have to search for children from root.next, so we want all the children to be fully connected first.
	• Example:
For this tree:

        1
       / \
      2   3
     /     \
    4       5
    
		○ First, connect(root.right = 3):
			§ Connect 5 → NULL (since 3 has no next).
		○ Then, connect(root.left = 2):
			§ Connect 4 → 5.

5️) Return the Root

return root;
	• After all the connections are made, we return the modified root.

6️) Helper Function (getNextChild)

private Node getNextChild(Node node) {
    while (node != null) {
        if (node.left != null) return node.left; // Return first available left child
        if (node.right != null) return node.right; // Return first available right child
        node = node.next; // Move to the next node
    }
    return null; // No child found
}
	• Why?
This function helps us find the first child in the next subtree.
It moves along node.next until it finds a left or right child.
If no child is found, it returns null.
	• Example:
For the following tree:

        1
       / \
      2   3
     /     \
    4       5
		○ If we are at 2, and we call getNextChild(3),
			§ 3.left = null
			§ 3.right = 5
			§ So, it returns 5, and we link 4 → 5.

Final Tree Example
Input

         1
       /   \
      2     3
     /       \
    4         5
Step-by-step Execution

1 → NULL
2 → 3 → NULL
4 → 5 → NULL

Serialized Output

[1, #, 2, 3, #, 4, 5, #]

Time Complexity
	• Every node is visited once, so the time complexity is O(N), where N is the number of nodes.

Space Complexity
	• The recursion stack uses O(h) space, where h is the height of the tree.
	• For a balanced binary tree, h = log(N).
	• For a skewed tree, h = N.

 */
