import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0, n, 0, 0, "");
        return result;
    }

    private void generate(int level, int max, int left, int right, String s) {
        // terminate
        if (level >= max * 2) {
            result.add(s);
            return;
        }
        // process current logic
        if (left < max){
            //drill down
            generate(level + 1, max, left + 1, right, s.concat("("));
        }

        if (left > right){
            //drill down
            generate(level + 1, max, left, right + 1, s.concat(")"));
        }
        // restore current state
    }

    public static void main(String[] args) {
        LeetCode22 code22 = new LeetCode22();
        code22.generateParenthesis(3);
    }
}
