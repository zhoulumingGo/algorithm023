class Solution {
    // 递归法
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }

        return res;
    }
}