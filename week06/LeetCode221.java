public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int left = 0;
        int top = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}

//        [
//        ["1","1","1","1","0"],
//        ["1","1","1","1","0"],
//        ["1","1","1","1","1"],
//        ["1","1","1","1","1"],
//        ["0","0","1","1","1"]
//        ]


//[
//        ["1","0","1","0","0"],
//        ["1","0","1","1","1"],
//        ["1","1","1","1","1"],
//        ["1","0","0","1","0"]
//        ]