import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        // 数组排序
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int minI = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minI > target) continue;
            int maxI = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (maxI < target) continue;

            for (int j = i + 1; j < length - 2; j++) {
                // 剪枝
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int minJ = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minJ > target) continue;
                int maxJ = nums[i] + nums[length - 2] + nums[length - 1] + nums[j];
                if (maxJ < target) continue;
                // 第三个值和第四值的位置
                int k = j + 1;
                int l = length - 1;
                while (k < l) {
                    int curr = nums[i] + nums[j] + nums[k] + nums[l];
                    if (target == curr) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (target > curr) {
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else {
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
