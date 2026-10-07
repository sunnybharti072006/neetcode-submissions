class Solution {
    public int goodNodes(TreeNode root) {
        return max(root, root.val);
    }
    public int max(TreeNode node, int max){
        if(node == null) return 0;
        int isGood = (node.val >= max) ? 1 : 0;
        int newMax = Math.max(max, node.val);
        return isGood + max(node.left, newMax) + max(node.right, newMax);
    }
}
