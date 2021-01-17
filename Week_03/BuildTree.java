class Solution {
    // 1、迭代法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<TreeNode>();
        int pre = 0;
        int in = 0;
        //先序遍历第一个值作为根节点
        TreeNode curRoot = new TreeNode(preorder[pre]);
        TreeNode root = curRoot;
        roots.push(curRoot);
        pre++;
        //遍历前序遍历的数组
        while (pre < preorder.length) {
            //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
            if (curRoot.val == inorder[in]) {
                //每次进行出栈，实现倒着遍历
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in++;
                }
                //设为当前的右孩子
                curRoot.right = new TreeNode(preorder[pre]);
                //更新 curRoot
                curRoot = curRoot.right;
                roots.push(curRoot);
                pre++;
            } else {
                //否则的话就一直作为左子树
                curRoot.left = new TreeNode(preorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                pre++;
            }
        }
        return root;
    }

    // // 2、递归法
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < inorder.length; i++) {
    //         map.put(inorder[i], i);
    //     }

    //     return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    // }

    // private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
    //                                 HashMap<Integer, Integer> map) {
    //     if (p_start == p_end) {
    //         return null;
    //     }
    //     int root_val = preorder[p_start];
    //     TreeNode root = new TreeNode(root_val);
    //     int i_root_index = map.get(root_val);
    //     int leftNum = i_root_index - i_start;
    //     root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
    //     root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        
    //     return root;
    // }

}