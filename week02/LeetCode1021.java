public class LeetCode1021 {
    public String removeOuterParentheses(String S) {
        int sign = 0;
        char[] charList = S.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            if (c == '(') sign = sign + 1;
            if (sign > 1) result.append(c);
            if (c == ')') sign = sign - 1;
        }
        return result.toString();
    }
}
