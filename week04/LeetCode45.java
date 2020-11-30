public class LeetCode45 {
    public int jump(int[] nums) {
        int index = 0;
        int maxReachable = 0;
        int step = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            maxReachable = Math.max(maxReachable, nums[i] + i);
            if (i == index) {
                index = maxReachable;
                step++;
            }
        }
        return step;
    }
}
