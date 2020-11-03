class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
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

    public boolean validMountainArray1(int[] A) {
        if (A.length < 3) return false;
        // 双指针
        int start = 0;
        int end = A.length - 1;
        while (A[start] < A[start + 1]) {
            if (start + 1 >= A.length - 1) break;
            start++;
        }
        while (A[end] < A[end - 1]) {
            if (end - 1 <= 0) break ;
            end --;
        }
        return start == end;
    }
}
