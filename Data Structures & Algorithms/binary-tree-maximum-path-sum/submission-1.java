class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
       maxSum = Integer.MIN_VALUE;
        maxfind(root);
        return maxSum;

    }
    public int maxfind(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0,maxfind(node.left));
        int right = Math.max(0,maxfind(node.right));

        int currentSum = left + node.val + right;

        maxSum = Math.max(currentSum, maxSum);
        return node.val + Math.max(left, right);
    }
}
