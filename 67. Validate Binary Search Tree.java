class Solution {
    long prev = Long.MIN_VALUE;  // To store the previous node value for comparison
    
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    // Helper function to perform inorder traversal
    private boolean inorder(TreeNode node) {
        if (node == null) return true; // If node is null, it's valid
        
        // Traverse left subtree
        if (!inorder(node.left)) return false;
        
        // Check if current node value is greater than the previous one
        if (node.val <= prev) return false;
        prev = node.val;  // Update the previous node value
        
        // Traverse right subtree
        return inorder(node.right);
    }
}
