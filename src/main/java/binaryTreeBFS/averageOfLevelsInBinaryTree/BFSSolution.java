package binaryTreeBFS.averageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
	 }
}

// Time complexity - O(n), Space complexity - O(n)
public class BFSSolution {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        
        if (root == null) return averages;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            double levelSum = 0;
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                
                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Calculate the average for this level
            double average = levelSum / levelSize;
            averages.add(average);
        }
        
        return averages;
    }
}
