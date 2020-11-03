public class LeetCode258 {
    public int addDigits(int num) {
        // 时间复杂度 O(1)
        // 100x + 10y + z = 99x + 9y + (x + y + z)
        return (num - 1) % 9 + 1;
    }
}
