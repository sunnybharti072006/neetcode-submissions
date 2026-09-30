class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }
}
