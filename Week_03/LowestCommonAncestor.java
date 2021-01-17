class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // 查找左节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 查找右节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (right == null) {
            return left;
        } else if (left == null) {
            return right;
        }

        return root;
    }
}