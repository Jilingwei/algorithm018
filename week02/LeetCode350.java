import java.util.Arrays;
import java.util.HashMap;

class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // hash表存储
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                count = count - 1;
                result[index ++] = num;
            }
            if(count > 0){
                map.put(num, count);
            }else{
                map.remove(num);
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
