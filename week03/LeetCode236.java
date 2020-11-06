public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminate
        if (root == null || root == p || root == q) return root;

        //process current logic
        //drill down
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        if (leftChild != null && rightChild != null) return root;

        if (leftChild == null) return rightChild;
        if (rightChild == null) return leftChild;
        // restore current statement

        return null;
    }
}
