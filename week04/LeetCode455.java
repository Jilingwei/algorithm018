import java.util.Arrays;

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index_s = 0, index_g = 0;
        while (index_g < g.length && index_s < s.length){
            if (s[index_s] >= g[index_g]){
                index_g ++;
            }
            index_s++;
        }
        return index_g;
    }
}
