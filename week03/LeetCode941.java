public class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        // 标记 0变大 1变小 sign改且只会改变一次状态
        int sign = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] == A[i - 1]) return false;
            if (A[i] < A[i - 1] && i == 1) return false;
            if (sign == 1 && A[i] > A[i - 1]) return false;
            if (sign == 0 && A[i] < A[i - 1]) {
                sign = 1;
            }
        }
        return sign == 1;
    }
}
