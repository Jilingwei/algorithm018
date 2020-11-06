public class LeetCode951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // terminate
        if (root1 == root2) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        // process current logic
        // dirll down
        boolean leftJudge = flipEquiv(root1.left, root2.right);
        boolean rightJudge = flipEquiv(root1.right, root2.left);

        boolean leftJudge1 = flipEquiv(root1.left, root2.left);
        boolean rightJudge1 = flipEquiv(root1.right, root2.right);

        return ((leftJudge && rightJudge) || (leftJudge1 && rightJudge1));
        // restore current state
    }
}
