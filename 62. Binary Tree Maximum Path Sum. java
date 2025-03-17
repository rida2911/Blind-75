class Solution {

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root) ;
        return maxSum ;
        
    }

    private int dfs(TreeNode node) {
        if(node == null ) return 0 ;

        int leftMax = Math.max(0 , dfs(node.left));
         int rightMax = Math.max(0 , dfs(node.right));


         maxSum = Math.max(maxSum , node.val +  leftMax + rightMax) ;

         return node.val + Math.max(leftMax , rightMax) ;


    }
}
