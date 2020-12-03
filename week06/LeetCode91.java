public class LeetCode91 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0'
                || s.contains("00")
                || s.contains("30")
                || s.contains("40")
                || s.contains("50")
                || s.contains("60")
                || s.contains("70")
                || s.contains("80")
                || s.contains("90")) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {

            if (s.charAt(i - 1) == '0') {
                dp[i] = dp[i - 2];

            } else if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
