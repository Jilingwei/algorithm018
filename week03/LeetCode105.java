import java.util.HashMap;

public class LeetCode105 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int lengthPre = preorder.length;
        int lengthIn = inorder.length;
        if (lengthIn != lengthPre) throw new RuntimeException("Incorrect input data !!");
        // 中序遍历存入HashMap
        for (int i = 0; i < map.size(); i++) {
            map.put(inorder[i], i);
        }
        return helpBuildTree(preorder, inorder, 1, lengthPre - 1, 0);
    }

    public TreeNode helpBuildTree(int[] preorder, int[]inorder, int preLeft, int max, int inLeft){
        // terminate
        if (preLeft > max) return null;

        
    }
}
