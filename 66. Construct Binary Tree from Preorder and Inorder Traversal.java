lass Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store index of each value in inorder for quick access
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find index of root in inorder
        int inorderIndex = inorderMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }
}
